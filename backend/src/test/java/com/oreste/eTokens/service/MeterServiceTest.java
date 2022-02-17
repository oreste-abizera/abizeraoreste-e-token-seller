package com.oreste.eTokens.service;

import com.oreste.eTokens.entity.Meter;
import com.oreste.eTokens.repository.MeterRepository;
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
public class MeterServiceTest {

    @Mock
    private MeterRepository meterRepositoryMock;

    @InjectMocks
    private MeterService meterService;

    @Test
    public void getAll_success() {
        when(meterRepositoryMock.findAll()).thenReturn(Arrays.asList(new Meter(10,"123456",null), new Meter(11,"432345",null)));
        assertEquals(10,meterService.getAllMeters().get(0).getMeterId());
        assertEquals("123456",meterService.getAllMeters().get(1).getMeterNumber());
    }

    @Test
    public void  getOneById_success(){
        Meter meter = new Meter(10,"1234567",null);
        when(meterRepositoryMock.findById(10L)).thenReturn(Optional.of(meter));
        assertEquals(meterService.getMeter(10L), meter);
    }

    @Test
    public void getOneById_failure(){
        Optional emptyOptional = Optional.empty();
        when(meterRepositoryMock.findById(10L)).thenReturn(emptyOptional);
        assertNull(meterService.getMeter(10L));
    }

    @Test
    public void save_success(){
        Meter meter = new Meter("123456");
        when(meterRepositoryMock.save(any(Meter.class))).thenReturn(meter);
        assertNotNull(meterService.saveMeter(meter).getMeterId());
        assertEquals(meter.getMeterNumber(), meterService.saveMeter(meter).getMeterNumber(),0);
    }

    @Test
    public void save_failure(){
        when(meterRepositoryMock.save(any(Meter.class))).thenReturn(null);
        assertTrue(meterService.saveMeter(new Meter("12345")) == null);
        assertNull(meterService.saveMeter(new Meter("123456")));
    }


}
