package at.altin.customerapp.service;

import at.altin.customerapp.data.repo.CustomerDao;
import at.altin.customerapp.exception.UserNotFoundException;
import at.altin.customerapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for Customer.
 * @author altin
 * @since 09.04.2023
 * @version 1.0
 */
@Service
public class CustomerService {
    private final CustomerDao customerRepo;

    @Autowired
    public CustomerService(CustomerDao customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer addCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public List<Customer> findAllCustomers(){
        return customerRepo.findAll();
    }

    public Customer updateCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer findCustomerById(Long id){
            return (Customer) customerRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User"+id+"not found!"));
    }

    public void deleteCustomer(Long id){
        customerRepo.deleteById(id);
    }
}
