package at.altin.customerapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author altin
 * @since 2023
 */
@Entity(name = "order_history")
public class OrderHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private PurchaseOrder orderPosition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PurchaseOrder getOrder() {
        return orderPosition;
    }

    public void setOrder(PurchaseOrder orderPosition) {
        this.orderPosition = orderPosition;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "id=" + id +
                ", customer=" + customer +
                ", order=" + orderPosition +
                '}';
    }
}

