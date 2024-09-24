package lab1.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    private Map<Integer, String> products = new HashMap<>();

    public ProductController() {
        products.put(1, "Product 1");
        products.put(2, "Product 2");
    }

    @GetMapping("/products/{productId}")
    public Map<String, String> getProduct(@PathVariable int productId) {
        Map<String, String> response = new HashMap<>();
        response.put("id", String.valueOf(productId));
        response.put("name", productId + " name");
        return response;
    }

    @PutMapping("/update/{productId}")
    public Map<String, String> updateProduct(@PathVariable int productId, @RequestParam String name) {
        Map<String, String> response = new HashMap<>();
        if (products.containsKey(productId)) {
            products.put(productId, name);
            response.put("success", "Product updated successfully");
            response.put("id", String.valueOf(productId));
            response.put("name", name);
        } else {
            response.put("error", "Product not found");
        }
        return response;
    }
}
