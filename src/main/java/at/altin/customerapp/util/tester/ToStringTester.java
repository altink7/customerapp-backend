package at.altin.customerapp.util.tester;

import at.altin.customerapp.util.StandardTester;
import at.altin.customerapp.util.Tester;

import java.lang.reflect.Method;

/**
 * Utility class to test the beginning of toString() method of a class.
 * Usage: ToStringTester.testToStringBeginning(Example.class);
 * Replace Example. Class with the class you want to test.
 * <p>
 * This utility class tests whether the beginning of the toString() method of a given class
 * starts with the class name followed by a '{'. It can be used to quickly check the basic
 * formatting of the toString() implementation.
 * </p>
 * <p>
 * Note: The utility class handles both enums and regular classes.
 * </p>
 *
 * @author altin
 * @since 12.08.2023
 * @version 1.0
 */
public class ToStringTester implements Tester, StandardTester {

    /**
     * Tests the beginning of the toString() method of the specified class.
     *
     * @param instance The class to test.
     */
    @Override
    public void test(Object instance) {
        Class<?> clazz = instance.getClass();
        try {
            // Get the toString() method of the class
            Method toStringMethod = getToStringMethod(clazz);

            // If the class doesn't have a toString() method, print a message and return
            if (toStringMethod == null) {
                System.out.println("Class " + clazz.getSimpleName() + " does not have a toString() method.");
                return;
            }

            Object instanceTest = createInstance(clazz);

            // Define the expected beginning of the toString() representation
            String expectedBeginning = clazz.getSimpleName() + "{";

            // Invoke the toString() method and check if it starts with the expected beginning
            String actualToString = (String) toStringMethod.invoke(instanceTest);
            if (!actualToString.startsWith(expectedBeginning)) {
                throw new AssertionError("Beginning of toString() method for class " + clazz.getSimpleName() + " failed.");
            } else {
                System.out.println("toString() beginning test passed for class " + clazz.getSimpleName());
            }
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Error testing toString() beginning for class " + clazz.getSimpleName(), e);
        }
    }

    /**
     * Retrieves the toString() method of the given class.
     *
     * @param clazz The class to retrieve the toString() method from.
     * @return The toString() method or null if not found.
     */
    private static Method getToStringMethod(Class<?> clazz) {
        try {
            return clazz.getDeclaredMethod("toString");
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /**
     * Creates an instance of the given class.
     *
     * @param clazz The class to create an instance of.
     * @return An instance of the class.
     */
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

