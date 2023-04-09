package at.altin.customerapp.service;

import at.altin.customerapp.data.repo.PurchaseOrderDao;
import at.altin.customerapp.model.OrderType;
import at.altin.customerapp.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for PurchaseOrder.
 * @author altin
 * @since 09.04.2023
 * @version 1.0
 */
@Service
public class OrderService {
    PurchaseOrderDao purchaseOrderDao;

    @Autowired
    public OrderService(PurchaseOrderDao purchaseOrderDao) {
        this.purchaseOrderDao = purchaseOrderDao;
    }

    public void deleteOrder(Long id) {
        purchaseOrderDao.deleteById(id);
    }

    public void updateOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderDao.save(purchaseOrder);
    }

    public void addOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderDao.save(purchaseOrder);
    }

    public Iterable<PurchaseOrder> findAllOrders() {
        return purchaseOrderDao.findAll();
    }

    public PurchaseOrder findOrderById(Long id) {
        return purchaseOrderDao.findById(id).orElseThrow(() -> new IllegalStateException("Order with id " + id + " does not exist!"));
    }

    public void findOrderOfType(OrderType orderType) {
        List<PurchaseOrder> purchaseOrders = purchaseOrderDao.findAll();
        purchaseOrders.stream().filter(purchaseOrder -> purchaseOrder.getOrderType().equals(orderType.name())).forEachOrdered(System.out::println);
    }
}
