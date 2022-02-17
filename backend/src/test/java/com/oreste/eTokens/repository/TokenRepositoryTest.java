package com.oreste.eTokens.repository;

import com.oreste.eTokens.entity.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TokenRepositoryTest {

    @Autowired
    private TokenRepository tokenRepository;


    @Test
    public void findOne__success(){
        Optional<Token> token = tokenRepository.findById(1L);
        assertTrue(token.isPresent());
    }

    @Test
    public void findOne__fail(){
        Optional<Token> token = tokenRepository.findById(10L);
        assertFalse(token.isPresent());
    }

    @Test
    public void save__success(){
        Token createdToken = tokenRepository.save(new Token("123456",10,"106732",false));
        assertNotNull(createdToken.getTokenId());
        assertEquals("123456",createdToken.getTokenNumber());
    }

    @Test
    public void use__success(){
        Optional<Token> findById = tokenRepository.findById(1L);
        Token token = findById.get();
        token.setIsUsed(true);
        Token savedToken = tokenRepository.save(token);
        assertTrue(findById.isPresent());
        assertEquals(savedToken.getIsUsed(),true);
    }

    @Test(expected = NoSuchElementException.class)
    public void use__fail(){
        Optional<Token> findById = tokenRepository.findById(10L);
        Token token = findById.get();
        token.setMeterNumber("34543");
        Token savedToken = tokenRepository.save(token);
        assertFalse(findById.isPresent());
    }
}