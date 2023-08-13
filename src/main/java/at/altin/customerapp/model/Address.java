package at.altin.customerapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author altin
 * @since 2023
 */

@Entity(name = "Address")
public class Address implements Serializable {

    private static final long serialVersionUID = 7876904359463936168L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String type; // shipping or billing

    private String street;

    private String city;

    private String state;

    private String country;

    private String zipCode;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", customer=" + customer +
                ", type='" + type + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(customer, address.customer) && Objects.equals(type, address.type) && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(country, address.country) && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, type, street, city, state, country, zipCode);
    }

    public Address copy() {
        Address copy = new Address();
        copy.id = this.id;
        copy.customer = this.customer;
        copy.type = this.type;
        copy.street = this.street;
        copy.city = this.city;
        copy.state = this.state;
        copy.country = this.country;
        copy.zipCode = this.zipCode;
        return copy;
    }
}
