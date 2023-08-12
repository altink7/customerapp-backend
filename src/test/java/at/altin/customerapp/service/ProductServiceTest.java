package at.altin.customerapp.service;

import at.altin.customerapp.data.repo.ProductDao;
import at.altin.customerapp.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductDao productRepo;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteProduct() {
        Long productId = 1L;

        productService.deleteProduct(productId);

        verify(productRepo, times(1)).deleteById(productId);
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();

        productService.updateProduct(product);

        verify(productRepo, times(1)).save(product);
    }

    @Test
    void testFindProductById() {
        Long productId = 1L;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);

        when(productRepo.findById(productId)).thenReturn(Optional.of(expectedProduct));

        Product foundProduct = productService.findProductById(productId);

        assertEquals(expectedProduct, foundProduct);
    }

    @Test
    void testAddProduct() {
        Product product = new Product();
        when(productRepo.save(product)).thenReturn(product);

        Product savedProduct = productService.addProduct(product);

        assertEquals(product, savedProduct);
    }

    @Test
    void testFindAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());

        when(productRepo.findAll()).thenReturn(products);

        Iterable<Product> foundProducts = productService.findAllProducts();

        assertEquals(products, foundProducts);
    }

    @Test
    void testFindAllProductsSorted() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());

        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        when(productRepo.findAll(sort)).thenReturn(products);

        Iterable<Product> foundProducts = productService.findAllProducts(sort);

        assertEquals(products, foundProducts);
    }
}