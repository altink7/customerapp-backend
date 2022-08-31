package at.altin.fullstackweb.service;

import at.altin.fullstackweb.model.Customer;
import at.altin.fullstackweb.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

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
}
