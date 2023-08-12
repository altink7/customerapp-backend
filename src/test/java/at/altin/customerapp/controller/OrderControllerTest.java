package at.altin.customerapp.controller;

import at.altin.customerapp.model.OrderType;
import at.altin.customerapp.model.PurchaseOrder;
import at.altin.customerapp.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetOrders() {
        List<PurchaseOrder> orders = new ArrayList<>();
        orders.add(new PurchaseOrder());

        when(orderService.findAllOrders()).thenReturn(orders);

        ResponseEntity<Iterable<PurchaseOrder>> response = orderController.getOrders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }

    @Test
    void testGetOrdersSorted() {
        List<PurchaseOrder> orders = new ArrayList<>();
        orders.add(new PurchaseOrder());

        when(orderService.findAllOrders(Sort.by(Sort.Direction.ASC, "orderType"))).thenReturn(orders);

        ResponseEntity<Iterable<PurchaseOrder>> response = orderController.getOrdersSorted();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }

    @Test
    void testGetOrdersSortedDesc() {
        List<PurchaseOrder> orders = new ArrayList<>();
        orders.add(new PurchaseOrder());

        when(orderService.findAllOrders(Sort.by(Sort.Direction.DESC, "orderType"))).thenReturn(orders);

        ResponseEntity<Iterable<PurchaseOrder>> response = orderController.getOrdersSortedDesc();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }

    @Test
    void testGetOrdersSortedByPrice() {
        List<PurchaseOrder> orders = new ArrayList<>();
        orders.add(new PurchaseOrder());

        when(orderService.findAllOrders(Sort.by(Sort.Direction.ASC, "price"))).thenReturn(orders);

        ResponseEntity<Iterable<PurchaseOrder>> response = orderController.getOrdersSortedByPrice();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }

    @Test
    void testGetOrderById() {
        Long orderId = 1L;
        PurchaseOrder order = new PurchaseOrder();
        order.setId(orderId);

        when(orderService.findOrderById(orderId)).thenReturn(order);

        ResponseEntity<PurchaseOrder> response = orderController.getOrderById(orderId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(order, response.getBody());
    }

    @Test
    void testGetOrdersByType() {
        List<PurchaseOrder> orders = new ArrayList<>();
        orders.add(new PurchaseOrder());

        when(orderService.findOrderOfType(OrderType.SHOPPING)).thenReturn(orders);

        ResponseEntity<Iterable<PurchaseOrder>> response = orderController.getOrdersByType(OrderType.SHOPPING);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }

    @Test
    void testAddOrder() {
        PurchaseOrder newOrder = new PurchaseOrder();
        PurchaseOrder savedOrder = new PurchaseOrder();
        savedOrder.setId(1L);

        when(orderService.addOrder(newOrder)).thenReturn(savedOrder);

        ResponseEntity<PurchaseOrder> response = orderController.addOrder(newOrder);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(savedOrder, response.getBody());
    }

    @Test
    void testUpdateOrder() {
        PurchaseOrder orderToUpdate = new PurchaseOrder();
        PurchaseOrder updatedOrder = new PurchaseOrder();
        updatedOrder.setId(1L);

        ResponseEntity<PurchaseOrder> response = orderController.updateOrder(orderToUpdate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testDeleteOrder() {
        Long orderId = 1L;

        ResponseEntity<?> response = orderController.deleteOrder(orderId);

        verify(orderService, times(1)).deleteOrder(orderId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
