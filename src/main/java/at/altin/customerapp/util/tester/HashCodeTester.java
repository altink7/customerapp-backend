package at.altin.customerapp.util.tester;

import at.altin.customerapp.util.ModelTester;
import at.altin.customerapp.util.StandardTester;
import at.altin.customerapp.util.Tester;

import java.lang.reflect.Method;

/**
 * Utility class to test the correctness of the hashCode() method of a class.
 * This class tests whether the hashCode() method of a given class produces consistent results,
 * and it handles both enums and regular classes.
 * If the hashCode() method is not defined in the class, it is not tested.
 *
 * Note: Enums usually have predefined hashCode() implementations.
 * @see EqualsTester
 * @see ModelTester
 * @author altin
 * @since 12.08.2023
 * @version 1.0
 */
public class HashCodeTester implements Tester, StandardTester {

    @Override
    public void test(Object instance) {
        Class<?> clazz = instance.getClass();
        Method hashCodeMethod = getHashCodeMethod(clazz);
        if (hashCodeMethod == null) {
            return; // No hashCode method, nothing to test
        }

        Object instance1 = createInstance(clazz);
        Object instance2 = createInstance(clazz);

        if (instance1.equals(instance2) && instance1.hashCode() != instance2.hashCode()) {
            throw new AssertionError("Consistency property of hashCode method failed for class " + clazz.getSimpleName());
        }
    }

    private static Method getHashCodeMethod(Class<?> clazz) {
        try {
            return clazz.getDeclaredMethod("hashCode");
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
