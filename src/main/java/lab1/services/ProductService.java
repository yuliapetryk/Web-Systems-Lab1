package lab1.services;

import lab1.entities.Product;
import lab1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {

        return productRepository.findAll();
    }

    @Cacheable(value = "products", key = "#id")
    public String getProduct(int id) {

        return productRepository.findNameById(id);
    }
}