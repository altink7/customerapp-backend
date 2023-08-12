package at.altin.customerapp.controller;

import at.altin.customerapp.data.repo.ProductDao;
import at.altin.customerapp.model.Product;
import at.altin.customerapp.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());

        when(productService.findAllProducts()).thenReturn(products);

        ResponseEntity<Iterable<Product>> response = productController.getProducts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
    }

    @Test
    void testGetProductsSorted() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());

        when(productService.findAllProducts(Sort.by(Sort.Direction.ASC, "name"))).thenReturn(products);

        ResponseEntity<Iterable<Product>> response = productController.getProductsSorted();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
    }

    @Test
    void testGetProductsSortedDesc() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());

        when(productService.findAllProducts(Sort.by(Sort.Direction.DESC, "name"))).thenReturn(products);

        ResponseEntity<Iterable<Product>> response = productController.getProductsSortedDesc();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
    }

    @Test
    void testAddProduct() {
        Long productId = 1L;
        Product product = new Product();
        product.setId(productId);

        when(productDao.getReferenceById(productId)).thenReturn(product);
        when(productService.addProduct(product)).thenReturn(product);

        ResponseEntity<Product> response = productController.addProduct(productId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void testUpdateProduct() {
        Long productId = 1L;
        Product product = new Product();
        product.setId(productId);

        when(productService.findProductById(productId)).thenReturn(product);

        ResponseEntity<Product> response = productController.updateProduct(productId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void testDeleteProduct() {
        Long productId = 1L;

        ResponseEntity<?> response = productController.deleteProduct(productId);

        verify(productService, times(1)).deleteProduct(productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
