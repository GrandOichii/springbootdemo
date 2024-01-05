package com.example.springbootdemo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/register")
    public ResponseEntity<GetClient> Register(@RequestBody LoginClient client) {
        try {
            var result = clientService.Register(client);
            return ResponseEntity.ok(result.toGetClient());
        } catch (UsernameTakenException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> Login(@RequestBody LoginClient client) {
        try {
            var result = clientService.Login(client);
            return ResponseEntity.ok(result);
        } catch (AuthenticationFailedException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
