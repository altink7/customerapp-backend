package at.altin.fullstackweb;

import at.altin.fullstackweb.model.*;
import at.altin.fullstackweb.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customer = customerService.findAllCustomers();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
