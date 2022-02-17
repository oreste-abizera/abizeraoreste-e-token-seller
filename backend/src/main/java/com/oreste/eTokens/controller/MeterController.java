package com.oreste.eTokens.controller;

import com.oreste.eTokens.entity.Meter;
import com.oreste.eTokens.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meters/")
public class MeterController {

    @Autowired
    private MeterService meterService;

    @GetMapping(path = "/hello")
    public String getMessage() {
        return "Hello meters controller";
    }

    @PostMapping("/save")
    public Meter saveMeter(@RequestBody Meter meter) {

        return meterService.saveMeter(meter);
    }

    @PutMapping("/update")
    public Meter updateMeter(@RequestBody Meter meter) {
        return meterService.updateMeter(meter);
    }

    @GetMapping("/getall")
    public List<Meter> getAllMeters() {
        return meterService.getAllMeters();
    }

    @GetMapping("/getone/{meterId}")
    public Meter getMeter(@PathVariable(name = "meterId") Long meterId) {
        return meterService.getMeter(meterId);
    }

    @DeleteMapping("/delete/{meterId}")
    public void deleteMeter(@PathVariable(name = "meterId") Long meterId) {
        meterService.deleteMeter(meterId);
    }
}
