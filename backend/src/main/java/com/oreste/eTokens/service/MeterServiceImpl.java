package com.oreste.eTokens.service;

import com.oreste.eTokens.entity.Meter;
import com.oreste.eTokens.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterServiceImpl implements MeterService {

    @Autowired
    MeterRepository meterRepository;

    @Override
    public Meter saveMeter(Meter meter) {
        return meterRepository.save(meter);
    }

    @Override
    public Meter updateMeter(Meter meter) {
        return meterRepository.save(meter);
    }


    @Override
    public List<Meter> getAllMeters() {
        return (List<Meter>) meterRepository.findAll();
    }

    @Override
    public Meter getMeter(Long meterId) {
        return meterRepository.findById(meterId).get();
    }

    @Override
    public void deleteMeter(Long meterId) {
        meterRepository.deleteById(meterId);
    }
}
