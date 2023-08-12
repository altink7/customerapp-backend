package at.altin.customerapp.service;

import at.altin.customerapp.data.repo.CustomerDao;
import at.altin.customerapp.exception.UserNotFoundException;
import at.altin.customerapp.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerDao customerRepo;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddCustomer() {
        Customer customer = new Customer();
        when(customerRepo.save(customer)).thenReturn(customer);

        Customer savedCustomer = customerService.addCustomer(customer);

        assertEquals(customer, savedCustomer);
    }

    @Test
    void testFindAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());

        when(customerRepo.findAll()).thenReturn(customers);

        List<Customer> foundCustomers = customerService.findAllCustomers();

        assertEquals(customers, foundCustomers);
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = new Customer();
        when(customerRepo.save(customer)).thenReturn(customer);

        Customer updatedCustomer = customerService.updateCustomer(customer);

        assertEquals(customer, updatedCustomer);
    }

    @Test
    void testFindCustomerById() {
        Long customerId = 1L;
        Customer expectedCustomer = new Customer();
        expectedCustomer.setId(customerId);

        when(customerRepo.findById(customerId)).thenReturn(Optional.of(expectedCustomer));

        Customer foundCustomer = customerService.findCustomerById(customerId);

        assertEquals(expectedCustomer, foundCustomer);
    }

    @Test
    void testFindCustomerByIdNotFound() {
        Long customerId = 1L;

        when(customerRepo.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> customerService.findCustomerById(customerId));
    }

    @Test
    void testDeleteCustomer() {
        Long customerId = 1L;

        customerService.deleteCustomer(customerId);

        verify(customerRepo, times(1)).deleteById(customerId);
    }
}
