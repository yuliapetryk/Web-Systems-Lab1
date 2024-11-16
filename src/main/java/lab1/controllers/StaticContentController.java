package lab1.controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class StaticContentController {
    private final ResourceLoader resourceLoader;

    public StaticContentController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/image")
    public ResponseEntity<Resource> getStaticContent() {
        Resource resource = resourceLoader.getResource("src\\main\\resources\\static\\image.jpg");
        return ResponseEntity.ok(resource);
    }
}
