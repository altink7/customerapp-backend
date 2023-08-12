package at.altin.customerapp.controller;

import at.altin.customerapp.data.repo.ProductDao;
import at.altin.customerapp.model.Product;
import at.altin.customerapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author altin
 * @since 09.04.2023
 * @version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductDao productDao;

    @Autowired
    public ProductController(ProductService productService, ProductDao productDao) {
        this.productService = productService;
        this.productDao = productDao;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Product>> getProducts() {
        Iterable<Product> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/all/sort")
    public ResponseEntity<Iterable<Product>> getProductsSorted() {
        Iterable<Product> products = productService.findAllProducts(Sort.by(Sort.Direction.ASC, "name"));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/all/sort/desc")
    public ResponseEntity<Iterable<Product>> getProductsSortedDesc() {
        Iterable<Product> products = productService.findAllProducts(Sort.by(Sort.Direction.DESC, "name"));
        return ResponseEntity.ok(products);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Product> addProduct(@PathVariable Long id) {
        Product product = productService.addProduct(productDao.getReferenceById(id));
        return ResponseEntity.ok(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id) {
        Product product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
