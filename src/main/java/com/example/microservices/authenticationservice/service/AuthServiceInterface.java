package com.example.microservices.authenticationservice.service;

import com.example.microservices.authenticationservice.generator.Token;

public interface AuthServiceInterface {

    String save(Token token);
    void deleteToken(Token token);
    Token findByTokenString(String tokenString);
}
