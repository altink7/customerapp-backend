package at.altin.customerapp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Utility class for comprehensive testing of model classes.
 * This class provides a flexible way to test various aspects of a model class,
 * including getter and setter methods, toString(), equals(), and hashCode().
 * You can configure the tests to be performed, exclude certain testers, exclude specific methods,
 * and supply custom instance creation logic.
 *
 * Usage example:
 * <pre>
 * {@code
 * ModelTester.forClass(YourClassToTest.class)
 *            .exclude(GetterSetterTester.class)
 *            .excludeMethods("hashCode")
 *            .customTester(new CustomTester()) // Use the custom tester
 *            .instanceSupplier(() -> {
 *                // Custom instance creation logic
 *            })
 *            .test();
 * }
 * </pre>
 *
 * @author altin
 * @since 12.08.2023
 * @version 1.0
 */
public class ModelTester {

    private final Class<?> clazz;
    private final List<Class<? extends Tester>> excludedTesters = new ArrayList<>();
    private final List<Tester> testers = new ArrayList<>();
    private Supplier<Object> instanceSupplier;

    private ModelTester(Class<?> clazz) {
        this.clazz = clazz;
        this.instanceSupplier = this::createInstance;

        // Automatically include testers implementing StandardTester
        includeStandardTesters();
    }

    public static ModelTester forClass(Class<?> clazz) {
        return new ModelTester(clazz);
    }

    public ModelTester exclude(Class<? extends Tester> testerClass) {
        excludedTesters.add(testerClass);
        return this;
    }

    public ModelTester customTester(Tester tester) {
        testers.add(tester);
        return this;
    }

    public ModelTester instanceSupplier(Supplier<Object> supplier) {
        instanceSupplier = supplier;
        return this;
    }

    public void test() {
        Object instance = instanceSupplier.get();

        testers.forEach(tester -> tester.test(instance));
        runExcludedTesters(instance);
    }

    private void runExcludedTesters(Object instance) {
        excludedTesters.stream()
                .filter(testerClass -> !isTesterExcluded(testerClass))
                .forEach(testerClass -> {
                    try {
                        Tester testerInstance = testerClass.getDeclaredConstructor().newInstance();
                        testerInstance.test(instance);
                    } catch (ReflectiveOperationException e) {
                        throw new RuntimeException("Error creating instance of tester class " + testerClass.getSimpleName(), e);
                    }
                });
    }

    private boolean isTesterExcluded(Class<? extends Tester> testerClass) {
        return excludedTesters.stream()
                .anyMatch(excludedTester -> excludedTester.equals(testerClass));
    }


    private void includeStandardTesters() {
        for (Class<?> testerClass : clazz.getDeclaredClasses()) {
            // check if tester is marked with tester, standard-tester interface
            if (Tester.class.isAssignableFrom(testerClass) && StandardTester.class.isAssignableFrom(testerClass)) {
                try {
                    testers.add((Tester) testerClass.getDeclaredConstructor().newInstance());
                } catch (ReflectiveOperationException e) {
                    throw new RuntimeException("Error creating instance of tester class " + testerClass.getSimpleName(), e);
                }
            }
        }
    }

    private Object createInstance() {
        try {
            if (clazz.isEnum()) {
                return clazz.getEnumConstants()[0];
            }
            return clazz.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Error creating instance of class " + clazz.getSimpleName(), e);
        }
    }
}
