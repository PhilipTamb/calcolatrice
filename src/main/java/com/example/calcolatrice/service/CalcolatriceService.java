package com.example.calcolatrice.service;

import com.example.calcolatrice.model.Calcolatrice;
import org.springframework.stereotype.Service;

@Service
public class CalcolatriceService implements com.example.calcolatrice.service.ICalcolatriceService {


    @Override
    public Double getResult(Calcolatrice c) {
        return c.makeOperation();
    }
}
