package com.oreste.eTokens.repository;

import com.oreste.eTokens.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
    Token getOneByTokenNumber(String tokenNumber);
}
