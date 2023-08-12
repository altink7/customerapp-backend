package at.altin.customerapp.model;

import at.altin.customerapp.util.ModelTester;
import at.altin.customerapp.util.Tester;
import at.altin.customerapp.util.tester.GetterSetterTester;
import at.altin.customerapp.util.tester.ToStringTester;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ModelUnitTest {

    @ParameterizedTest
    @MethodSource("classProvider")
    void testModelClasses(Class<?> clazz) {
        ModelTester.forClass(clazz).test();
    }

    // Method to provide the classes for testing
    static Stream<Class<?>> classProvider() {
        return Stream.of(
                Address.class,
                Customer.class,
                OrderHistory.class,
                OrderItem.class,
                OrderType.class,
                Payment.class,
                Product.class,
                Promotion.class,
                PurchaseOrder.class,
                Review.class,
                WishList.class
        );
    }
}