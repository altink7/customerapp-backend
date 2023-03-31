package at.altin.customerapp.repo;
import at.altin.customerapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{

    void deleteCustomerById(Long id);

    Optional<Customer> findCustomerById(Long id);
}
