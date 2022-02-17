package com.oreste.eTokens.controller;

import com.oreste.eTokens.entity.Meter;
import com.oreste.eTokens.entity.Token;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TokenControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void getById_success() throws JSONException {
        ResponseEntity<Token> response = this.restTemplate.getForEntity("/tokens/getOne/101", Token.class);
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    public void getById_notFound() {
        ResponseEntity<Token> response = this.restTemplate.getForEntity("/tokens/getOne/554",Token.class);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void save_Success() {

        Token token1 = new Token("1234567",10,"12345",false);

        ResponseEntity<Token> response = this.restTemplate.postForEntity("/tokens/save", token1, Token.class);

        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    public void save_failure() {


        Token token1 = new Token("1234567",10,null,null);

        ResponseEntity<Token> response = this.restTemplate.postForEntity("/tokens/save",token1, Token.class);

        assertEquals(400, response.getStatusCodeValue());
    }



}