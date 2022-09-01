package at.altin.fullstackweb.repo;
import at.altin.fullstackweb.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

    void deleteCustomerById(Long id);

    Optional findCustomerById(Long id);
}
