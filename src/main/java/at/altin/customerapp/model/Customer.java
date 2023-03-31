package at.altin.customerapp.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity(name = "Customer")
public class Customer implements Serializable {
    
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private boolean company;
    private String email;
    private String phone;
    private String imageUrl;

    /**
     * @author altin
     * @since 2023
     */
    public Customer(String name, boolean company, String email, String phone, String imageUrl) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompany() {
        return company;
    }

    public void setCompany(boolean company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }


    @OneToMany(mappedBy = "customer")
    private Collection<PurchaseOrder> orderPosition;

    public Collection<PurchaseOrder> getOrder() {
        return orderPosition;
    }

    public void setOrder(Collection<PurchaseOrder> orderPosition) {
        this.orderPosition = orderPosition;
    }
}
