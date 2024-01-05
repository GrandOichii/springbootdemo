package com.example.springbootdemo.client;

import jakarta.persistence.*;

@Entity
@Table
public class Client {
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", passwordHash='" + passwordHash + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    public long id;

    public Client() {

    }

    public Client(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    private String passwordHash;
    private String username;

    public GetClient toGetClient() {
        return new GetClient(this.username);
    }
}
