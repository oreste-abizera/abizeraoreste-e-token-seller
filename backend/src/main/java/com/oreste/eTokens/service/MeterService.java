package com.oreste.eTokens.service;

import com.oreste.eTokens.entity.Meter;

import java.util.List;

public interface MeterService {

    Meter saveMeter(Meter meter);
    Meter updateMeter(Meter meter);
    List<Meter> getAllMeters();
    Meter getMeter(Long meterId);
    void deleteMeter(Long meterId);
}
