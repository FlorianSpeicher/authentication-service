package com.example.microservices.authenticationservice.repository;

import com.example.microservices.authenticationservice.generator.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
}
