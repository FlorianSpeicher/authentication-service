package com.example.microservices.authenticationservice.service;

import com.example.microservices.authenticationservice.generator.Token;
import com.example.microservices.authenticationservice.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AuthService implements AuthServiceInterface{

    private TokenRepository tokenRepository;

    @Autowired
    public AuthService(TokenRepository tokenRepository){
        this.tokenRepository = tokenRepository;
    }
    @Override
    public String save(Token token) {
        tokenRepository.save(token);
        return token.getTokenString();

    }

    @Override
    public void deleteToken(Token token) {
        tokenRepository.delete(token);
    }

    @Override
    public Token findByTokenString(String tokenString) {
        List<Token>tokenList = tokenRepository.findAll();
        List<Token> tokenList1 = new ArrayList<>();
        for (Token token: tokenList) {
            if (Objects.equals(token.getTokenString(), tokenString)){
                tokenList1.add(token);
            }
        }
        if (tokenList1.isEmpty()){
            Token nonValidToken = new Token();
            nonValidToken.setTokenString("nonValidToken");
            return  nonValidToken;
        }else {
            return tokenList1.get(0);
        }
    }
}
