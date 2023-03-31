package at.altin.customerapp.service;

import at.altin.customerapp.model.Product;
import at.altin.customerapp.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author altin
 * @since 2023
 * Service for Product
 */
@Service
public class ProductService {
    ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void deleteProduct(Long id){
        productRepo.deleteProductById(id);
    }

    public void updateProduct(Product product){
        productRepo.save(product);
    }

    public Product findProductById(Long id){
        return productRepo.findProductById(id).orElseThrow(()-> new IllegalStateException("Product with id "+id+" does not exist!"));
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public Iterable<Product> findAllProducts(){
        return productRepo.findAll();
    }
}
