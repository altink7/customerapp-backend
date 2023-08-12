package at.altin.customerapp.controller;

import at.altin.customerapp.model.OrderType;
import at.altin.customerapp.model.PurchaseOrder;
import at.altin.customerapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author altin
 * @since 09.04.2023
 * @version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<PurchaseOrder>> getOrders() {
        Iterable<PurchaseOrder> orders = orderService.findAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("all/sort")
    public ResponseEntity<Iterable<PurchaseOrder>> getOrdersSorted() {
        Iterable<PurchaseOrder> orders = orderService.findAllOrders(Sort.by(Sort.Direction.ASC, "orderType"));
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/all/sort/desc")
    public ResponseEntity<Iterable<PurchaseOrder>> getOrdersSortedDesc() {
        Iterable<PurchaseOrder> orders = orderService.findAllOrders(Sort.by(Sort.Direction.DESC, "orderType"));
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/all/sort/price")
    public ResponseEntity<Iterable<PurchaseOrder>> getOrdersSortedByPrice() {
        Iterable<PurchaseOrder> orders = orderService.findAllOrders(Sort.by(Sort.Direction.ASC, "price"));
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PurchaseOrder> getOrderById(@PathVariable Long id) {
        PurchaseOrder order = orderService.findOrderById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/find/type/{type}")
    public ResponseEntity<Iterable<PurchaseOrder>> getOrdersByType(@PathVariable OrderType type) {
        Iterable<PurchaseOrder> orders = orderService.findOrderOfType(type);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/add")
    public ResponseEntity<PurchaseOrder> addOrder(@RequestBody PurchaseOrder order) {
        PurchaseOrder newOrder = orderService.addOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    @PutMapping("/update")
    public ResponseEntity<PurchaseOrder> updateOrder(@RequestBody PurchaseOrder order) {
        PurchaseOrder updatedOrder = orderService.addOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
