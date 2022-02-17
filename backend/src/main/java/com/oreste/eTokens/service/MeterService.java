package com.oreste.eTokens.service;

import com.oreste.eTokens.entity.Meter;

import java.util.List;

public interface MeterService {

    Meter saveMeter(Meter employee);
    Meter updateMeter(Meter employee);
    List<Meter> getAllMeters();
    Meter getMeter(Long employeeId);
    void deleteMeter(Long employeeId);
}
