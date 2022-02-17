package com.oreste.eTokens.repository;

import com.oreste.eTokens.entity.Meter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MeterRepositoryTest {

    @Autowired
    private MeterRepository meterRepository;

    @Test
    public void getAll__success(){
        List<Meter> meters = meterRepository.findAll();
        assertEquals(meters.size(),0);
    }

    @Test
    public void findOne__success(){
        Optional<Meter> meter = meterRepository.findById(1L);
        assertTrue(meter.isPresent());
    }

    @Test
    public void findOne__fail(){
        Optional<Meter> meter = meterRepository.findById(10L);
        assertFalse(meter.isPresent());
    }

    @Test
    public void create__success(){
        Meter createdMeter = meterRepository.save(new Meter("123456"));
        assertNotNull(createdMeter.getMeterId());
        assertEquals("123456",createdMeter.getMeterNumber());
    }

    @Test
    public void update__success(){
        Optional<Meter> findById = meterRepository.findById(1L);
        Meter meter = findById.get();
        meter.setBillExpiration(new Date(2022,02,02));
        Meter savedMeter = meterRepository.save(meter);
        assertTrue(findById.isPresent());
        assertEquals(savedMeter.getBillExpiration(),new Date(2022,02,02));
    }

    @Test(expected = NoSuchElementException.class)
    public void update__fail(){
        Optional<Meter> findById = meterRepository.findById(10L);
        Meter meter = findById.get();
        meter.setMeterNumber("34543");
        Meter savedMeter = meterRepository.save(meter);
        assertFalse(findById.isPresent());
    }

    @Test()
    public void delete__success(){
        List<Meter> meters = meterRepository.findAll();
        meterRepository.deleteById(2L);
        List<Meter> newMeters = meterRepository.findAll();
        assertFalse(meters.size() == newMeters.size());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void delete__fail(){
        List<Meter> meters = meterRepository.findAll();
        meterRepository.deleteById(10L);
        List<Meter> newMeters = meterRepository.findAll();
        assertTrue(meters.size() == newMeters.size());
    }

}