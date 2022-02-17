package com.oreste.eTokens.service;

import com.oreste.eTokens.entity.Meter;
import com.oreste.eTokens.entity.Token;
import com.oreste.eTokens.repository.MeterRepository;
import com.oreste.eTokens.repository.TokenRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TokenServiceTest {

    @Mock
    private TokenRepository tokenRepositoryMock;

    @InjectMocks
    private TokenService tokenService;

    @Test
    public void  getOneById_success(){
        Token token = new Token("123456",10,"123456",false);
        when(tokenRepositoryMock.findById(10L)).thenReturn(Optional.of(token));
        assertEquals(tokenService.getToken("123456"), token);
    }

    @Test
    public void getOneById_failure(){
        Optional emptyOptional = Optional.empty();
        when(tokenRepositoryMock.findById(10L)).thenReturn(emptyOptional);
        assertNull(tokenService.getToken("123456"));
    }

    @Test
    public void save_success(){
        Token token = new Token("123456",10,"123456",false);
        when(tokenRepositoryMock.save(any(Token.class))).thenReturn(token);
        assertNotNull(tokenService.saveToken(token).getTokenId());
        assertEquals(token.getTokenNumber(), tokenService.saveToken(token).getTokenNumber(),0);
    }

    @Test
    public void save_failure(){
        when(tokenRepositoryMock.save(any(Token.class))).thenReturn(null);
        assertTrue(tokenService.saveToken(new Token("123456",10,"123456",false)) == null);
        assertNull(tokenService.saveToken(new Token("123456",10,"123456",false)));
    }


}
