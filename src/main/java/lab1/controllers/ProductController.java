package lab1.controllers;

import lab1.entities.Product;
import lab1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/productsAll")
    public List<Product> getProducts() {
        List<Product> products = productService.getProducts();
        return products;
    }

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable int id) {
        String products = productService.getProduct(id);
        return products;
    }

}
