package com.example.springbootdemo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client Register(LoginClient client) throws UsernameTakenException {
        var existing = clientRepository.findClientByUsername(client.getUsername());
        if (existing.isPresent()) throw new UsernameTakenException(client.getUsername());

        var newUser = new Client();
        newUser.setUsername(client.getUsername());
        newUser.setPasswordHash(client.getPassword());
        clientRepository.save(newUser);
        return newUser;
    }

    public String Login(LoginClient client) throws AuthenticationFailedException {
        var existing = clientRepository.findClientByUsername(client.getUsername());
        if (existing.isEmpty()) throw new AuthenticationFailedException();

//        TODO check hashed password
        var actualUser = existing.get();
        if (!actualUser.getPasswordHash().equals(client.getPassword())) throw new AuthenticationFailedException();

//        TODO return actual JWT token
        return "jwt test token";
    }
}
