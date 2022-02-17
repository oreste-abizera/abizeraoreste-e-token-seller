package com.oreste.eTokens.service;

import com.oreste.eTokens.entity.Meter;
import com.oreste.eTokens.entity.Token;

public interface TokenService {
    Token saveToken(Token token);
    Meter useToken (String tokenNumber);
    Token getToken(String tokenNumber);
}
