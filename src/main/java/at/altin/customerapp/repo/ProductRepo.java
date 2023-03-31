package at.altin.customerapp.repo;

import at.altin.customerapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author altin
 * @since 2023
 * Repository for Product
 */
@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    void deleteProductById(Long id);
    Optional<Product> findProductById(Long id);
}
