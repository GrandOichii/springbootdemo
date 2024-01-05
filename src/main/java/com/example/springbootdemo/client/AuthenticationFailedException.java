package com.example.springbootdemo.client;

import javax.naming.AuthenticationException;

public class AuthenticationFailedException extends AuthenticationException {
    public AuthenticationFailedException() {
        super("authentication failed");
    }
}
