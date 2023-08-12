package at.altin.customerapp.model;

import at.altin.customerapp.util.GetterSetterTester;
import at.altin.customerapp.util.ToStringTester;
import org.junit.jupiter.api.Test;

class ModelUnitTest {

    @Test
    public void testCustomerGettersAndSetters() {
        GetterSetterTester.testGetterSetter(Customer.class);
        ToStringTester.testToStringBeginning(Customer.class);
    }

    @Test
    public void testOrderHistoryGettersAndSetters() {
        GetterSetterTester.testGetterSetter(OrderHistory.class);
        ToStringTester.testToStringBeginning(OrderHistory.class);
    }

    @Test
    public void testOrderItemGettersAndSetters() {
        GetterSetterTester.testGetterSetter(OrderItem.class);
        ToStringTester.testToStringBeginning(OrderItem.class);
    }

    @Test
    public void testOrderTypeGettersAndSetters() {
        GetterSetterTester.testGetterSetter(OrderType.class);
        ToStringTester.testToStringBeginning(OrderType.class);
    }

    @Test
    public void testPaymentGettersAndSetters() {
        GetterSetterTester.testGetterSetter(Payment.class);
        ToStringTester.testToStringBeginning(Payment.class);
    }

    @Test
    public void testProductGettersAndSetters() {
        GetterSetterTester.testGetterSetter(Product.class);
        ToStringTester.testToStringBeginning(Product.class);
    }

    @Test
    public void testPromotionGettersAndSetters() {
        GetterSetterTester.testGetterSetter(Promotion.class);
        ToStringTester.testToStringBeginning(Promotion.class);
    }

    @Test
    public void testPurchaseOrderGettersAndSetters() {
        GetterSetterTester.testGetterSetter(PurchaseOrder.class);
        ToStringTester.testToStringBeginning(PurchaseOrder.class);
    }

    @Test
    public void testReviewGettersAndSetters() {
        GetterSetterTester.testGetterSetter(Review.class);
        ToStringTester.testToStringBeginning(Review.class);
    }

    @Test
    public void testWishListGettersAndSetters() {
        GetterSetterTester.testGetterSetter(WishList.class);
        ToStringTester.testToStringBeginning(WishList.class);
    }
}