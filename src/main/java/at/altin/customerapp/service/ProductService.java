package at.altin.customerapp.service;

import at.altin.customerapp.model.Product;
import at.altin.customerapp.data.repo.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Service for Product
 * @author altin
 * @since 09.04.2023
 * @version 1.0
 */
@Service
public class ProductService {
    ProductDao productRepo;

    @Autowired
    public ProductService(ProductDao productRepo) {
        this.productRepo = productRepo;
    }

    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }

    public void updateProduct(Product product){
        productRepo.save(product);
    }

    public Product findProductById(Long id){
        return productRepo.findById(id).orElseThrow(()-> new IllegalStateException("Product with id "+id+" does not exist!"));
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public Iterable<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public Iterable<Product> findAllProducts(Sort orderType){
        return productRepo.findAll(orderType);
    }
}
