package com.example.springbootdemo.client;

import javax.naming.AuthenticationException;

public class UsernameTakenException extends AuthenticationException {
    public UsernameTakenException(final String username) {
        super("username " + username + " is already taken");
    }
}
