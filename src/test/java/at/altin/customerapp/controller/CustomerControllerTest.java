package at.altin.customerapp.controller;

import at.altin.customerapp.model.Customer;
import at.altin.customerapp.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John Doe", false, "john@example.com", "123456789", "image1.jpg"));

        when(customerService.findAllCustomers()).thenReturn(customers);

        ResponseEntity<List<Customer>> response = customerController.getAllCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
    }

    @Test
    void testGetCustomerById() {
        Long customerId = 1L;
        Customer customer = new Customer("John Doe", false, "john@example.com", "123456789", "image1.jpg");
        customer.setId(customerId);

        when(customerService.findCustomerById(customerId)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.getCustomerById(customerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void testAddCustomer() {
        Customer newCustomer = new Customer("Jane Smith", false, "jane@example.com", "987654321", "image2.jpg");
        Customer savedCustomer = new Customer("Jane Smith", false, "jane@example.com", "987654321", "image2.jpg");
        savedCustomer.setId(1L);

        when(customerService.addCustomer(newCustomer)).thenReturn(savedCustomer);

        ResponseEntity<Customer> response = customerController.addCustomer(newCustomer);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(savedCustomer, response.getBody());
    }

    @Test
    void testUpdateCustomer() {
        Customer customerToUpdate = new Customer("Updated Name", false, "updated@example.com", "555555555", "image3.jpg");
        customerToUpdate.setId(1L);

        when(customerService.updateCustomer(customerToUpdate)).thenReturn(customerToUpdate);

        ResponseEntity<Customer> response = customerController.updateCustomer(customerToUpdate);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customerToUpdate, response.getBody());
    }

    @Test
    void testDeleteCustomer() {
        Long customerId = 1L;

        ResponseEntity<?> response = customerController.deleteCustomer(customerId);

        verify(customerService, times(1)).deleteCustomer(customerId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
