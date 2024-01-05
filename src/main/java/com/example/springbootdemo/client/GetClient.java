package com.example.springbootdemo.client;

public class GetClient {
    private String username;

    public GetClient(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
