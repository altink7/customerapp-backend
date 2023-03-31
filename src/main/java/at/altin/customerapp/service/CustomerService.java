package at.altin.customerapp.service;

import at.altin.customerapp.exception.UserNotFoundException;
import at.altin.customerapp.model.Customer;
import at.altin.customerapp.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
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
            return (Customer) customerRepo.findCustomerById(id).orElseThrow(()-> new UserNotFoundException("User"+id+"not found!"));
    }

    public void deleteCustomer(Long id){
        customerRepo.deleteCustomerById(id);
    }
}
