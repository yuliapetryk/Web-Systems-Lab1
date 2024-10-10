package lab1.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductControllerTests {

    private ProductController productController;
    @BeforeEach
    void setUp() {
        productController = new ProductController();
    }

    @Test
    public void testGetProduct() {

        int productId = 1;

        Map<String, String> response = productController.getProduct(productId);

        assertEquals(String.valueOf(productId), response.get("id"));
        assertEquals(productId + " name", response.get("name"));
    }
}
