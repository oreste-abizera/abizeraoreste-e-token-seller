package com.oreste.eTokens.controller;

import com.oreste.eTokens.entity.Meter;
import com.oreste.eTokens.entity.Token;
import com.oreste.eTokens.service.MeterService;
import com.oreste.eTokens.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tokens/")
public class TokeController {

    @Autowired
    private TokenService tokenService;

    @GetMapping(path = "/hello")
    public String getMessage() {
        return "Hello tokens controller";
    }

    @PostMapping("/save")
    public Token saveToken(@RequestBody Token token) {

        return tokenService.saveToken(token);
    }

    @PutMapping("/use")
    public Meter useToken(@RequestBody String tokenNumber) {
        return tokenService.useToken(tokenNumber);
    }

    @GetMapping("/getone/{tokenNumber}")
    public Token getToken(@PathVariable(name = "tokenNumber") String tokenNumber) {
        return tokenService.getToken(tokenNumber);
    }
}
