package com.example.microservices.authenticationservice.controller;

import com.example.microservices.authenticationservice.generator.Token;
import com.example.microservices.authenticationservice.service.AuthService;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Period;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    private final String nonValidTokenResponse = "nonValidToken";

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping("/token/generate")
    public String generateToken(){
        Token token = new Token();

        return authService.save(token);
    }

    @GetMapping("/token/validateAndUpdate")
    public String validateAndUpdateToken(@RequestBody String tokenString){

        final long timeDiff = 30000;
        Token token = authService.findByTokenString(tokenString);
        if (Objects.equals(token.getTokenString(), nonValidTokenResponse)){
            return nonValidTokenResponse;
        }else {
            Token newToken = new Token();
            if ((newToken.getTimeStamp() - token.getTimeStamp()) <= timeDiff){
                authService.deleteToken(token);
                return authService.save(newToken);
            }else {
                authService.deleteToken(token);
                return nonValidTokenResponse;
            }
        }
    }

    @PostMapping("/token/invalidate")
    public void invalidateToken(@RequestBody String tokenString){
        Token token = authService.findByTokenString(tokenString);
        authService.deleteToken(token);

    }
}
