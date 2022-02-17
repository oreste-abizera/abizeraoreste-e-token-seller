package com.oreste.eTokens.controller;

import com.oreste.eTokens.entity.Meter;
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
public class MeterControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll_success() throws JSONException {
        String response = this.restTemplate.getForObject("/meters/getall", String.class);
        JSONAssert.assertEquals("[]", response, true);
    }

    @Test
    public void getById_success() throws JSONException {
        ResponseEntity<Meter> response = this.restTemplate.getForEntity("/meters/getOne/101", Meter.class);
        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(, response.getBody().getMeterNumber(),0);
//        assertEquals(, response.getBody().getBillExpiration());

    }

    @Test
    public void getById_notFound() {
        ResponseEntity<Meter> response = this.restTemplate.getForEntity("/meters/getOne/554",Meter.class);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    public void save_Success() {

        Meter meter1 = new Meter("1234567");

        ResponseEntity<Meter> response = this.restTemplate.postForEntity("/meters/save", meter1, Meter.class);

        assertEquals(201, response.getStatusCodeValue());
    }

    @Test
    public void save_failure() {


        Meter meter1 = new Meter("1234567");

        ResponseEntity<Meter> response = this.restTemplate.postForEntity("/meters/save",meter1, Meter.class);

        assertEquals(400, response.getStatusCodeValue());
    }



}