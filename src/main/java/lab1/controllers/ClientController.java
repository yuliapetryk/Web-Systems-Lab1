package lab1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientController {

    @GetMapping("/clients/{clientId}")
    public Map<String, String> getClient(@PathVariable int clientId) {
        Map<String, String> response = new HashMap<>();
        response.put("id", String.valueOf(clientId));
        response.put("client", clientId + " client");
        return response;
    }
}
