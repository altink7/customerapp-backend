package at.altin.customerapp.repo;

import at.altin.customerapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {
    void deleteProductById(Long id);
    void addProductById(Product product);
    Optional<Product> findCustomerById(Long id);

}
