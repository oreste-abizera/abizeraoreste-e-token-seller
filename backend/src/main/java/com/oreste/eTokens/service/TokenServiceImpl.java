package com.oreste.eTokens.service;

import com.oreste.eTokens.entity.Meter;
import com.oreste.eTokens.entity.Token;
import com.oreste.eTokens.repository.MeterRepository;
import com.oreste.eTokens.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    MeterRepository meterRepository;
    @Autowired
    TokenRepository tokenRepository;

    @Override
    public Token saveToken(Token token) {
        return tokenRepository.save(token);
    }

    @Override
    public Meter useToken(String tokenNumber) {
        Token token = tokenRepository.getOneByTokenNumber(tokenNumber);
        return meterRepository.getOneByMeterNumber(token.getMeterNumber());
    }

    @Override
    public Token getToken(String tokenNumber) {
        Token token = tokenRepository.getOneByTokenNumber(tokenNumber);
        return token;
    }
}
