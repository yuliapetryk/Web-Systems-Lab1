package lab1.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientController {

    private final Map<Integer, String> clients = new HashMap<>();

    public ClientController() {
        clients.put(1, "Client 1");
        clients.put(2, "Client 2");
    }

    @GetMapping("/clients/{clientId}")
    public Map<String, String> getClient(@PathVariable int clientId) {
        System.out.println("Test2");
        Map<String, String> response = new HashMap<>();
        response.put("id", String.valueOf(clientId));
        response.put("client", clientId + " client");
        return response;
    }

    @PutMapping("/update/{clientId}")
    public Map<String, String> updateClient(@PathVariable int clientId, @RequestParam String name) {
        Map<String, String> response = new HashMap<>();
        if (clients.containsKey(clientId)) {
            clients.put(clientId, name);
            response.put("success", "Client updated successfully");
            response.put("id", String.valueOf(clientId));
            response.put("client", name);
        } else {
            response.put("error", "Client not found");
        }
        return response;
    }
}
