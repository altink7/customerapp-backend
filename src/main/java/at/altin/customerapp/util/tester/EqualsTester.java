package at.altin.customerapp.util.tester;

import at.altin.customerapp.util.StandardTester;
import at.altin.customerapp.util.Tester;

import java.lang.reflect.Method;

/**
 * Utility class to test the correctness of the equals() method of a class.
 * This class tests whether the equals() method of a given class follows the contract rules
 * of reflexivity, symmetry, and consistency.
 * If the equals() method is not defined in the class, it is not tested.
 *
 * Note: Enums usually have predefined equals() implementations.
 * @author altin
 * @since 12.08.2023
 * @version 1.0
 */
public class EqualsTester implements Tester, StandardTester {

    @Override
    public void test(Object instance) {
        Class<?> clazz = instance.getClass();
        Method equalsMethod = getEqualsMethod(clazz);
        if (equalsMethod == null) {
            return; // No 'equals' method, nothing to test
        }

        Object instance1 = createInstance(clazz);
        Object instance2 = createInstance(clazz);

        if (!instance1.equals(instance1)) {
            throw new AssertionError("Reflexivity property of equals method failed for class " + clazz.getSimpleName());
        }

        if (instance1.equals(instance2) != instance2.equals(instance1)) {
            throw new AssertionError("Symmetry property of equals method failed for class " + clazz.getSimpleName());
        }

        if (instance1.equals(instance2) && instance2.equals(instance1)) {
            if (instance1.hashCode() != instance2.hashCode()) {
                throw new AssertionError("Consistency property of equals and hashCode methods failed for class " + clazz.getSimpleName());
            }
        }

        if (instance1.equals(null)) {
            throw new AssertionError("Null comparison in equals method failed for class " + clazz.getSimpleName());
        }
    }

    private static Method getEqualsMethod(Class<?> clazz) {
        try {
            return clazz.getDeclaredMethod("equals", Object.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static Object createInstance(Class<?> clazz) {
        try {
            if (clazz.isEnum()) {
                return clazz.getEnumConstants()[0];
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Error creating instance of class " + clazz.getSimpleName(), e);
        }
    }
}
