package at.altin.customerapp.service;

import at.altin.customerapp.data.repo.PurchaseOrderDao;
import at.altin.customerapp.model.OrderType;
import at.altin.customerapp.model.PurchaseOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private PurchaseOrderDao purchaseOrderDao;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteOrder() {
        Long orderId = 1L;

        orderService.deleteOrder(orderId);

        verify(purchaseOrderDao, times(1)).deleteById(orderId);
    }

    @Test
    void testUpdateOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();

        orderService.updateOrder(purchaseOrder);

        verify(purchaseOrderDao, times(1)).save(purchaseOrder);
    }

    @Test
    void testAddOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        when(purchaseOrderDao.save(purchaseOrder)).thenReturn(purchaseOrder);

        PurchaseOrder savedOrder = orderService.addOrder(purchaseOrder);

        assertEquals(purchaseOrder, savedOrder);
    }

    @Test
    void testFindAllOrders() {
        List<PurchaseOrder> orders = new ArrayList<>();
        orders.add(new PurchaseOrder());

        when(purchaseOrderDao.findAll()).thenReturn(orders);

        Iterable<PurchaseOrder> foundOrders = orderService.findAllOrders();

        assertEquals(orders, foundOrders);
    }

    @Test
    void testFindAllOrdersSorted() {
        List<PurchaseOrder> orders = new ArrayList<>();
        orders.add(new PurchaseOrder());

        Sort sort = Sort.by(Sort.Direction.ASC, "orderType");
        when(purchaseOrderDao.findAll(sort)).thenReturn(orders);

        Iterable<PurchaseOrder> foundOrders = orderService.findAllOrders(sort);

        assertEquals(orders, foundOrders);
    }

    @Test
    void testFindOrderById() {
        Long orderId = 1L;
        PurchaseOrder expectedOrder = new PurchaseOrder();
        expectedOrder.setId(orderId);

        when(purchaseOrderDao.findById(orderId)).thenReturn(Optional.of(expectedOrder));

        PurchaseOrder foundOrder = orderService.findOrderById(orderId);

        assertEquals(expectedOrder, foundOrder);
    }
}
