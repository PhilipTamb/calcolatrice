package com.example.calcolatrice.service;

import com.example.calcolatrice.model.Calcolatrice;
import com.example.calcolatrice.repository.CalcolatriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcolatriceService implements ICalcolatriceService{
    @Autowired
    private CalcolatriceRepository calcolatriceRepository;

    @Override
    public Double getResult(Calcolatrice c) {
        return c.makeOperation();
    }
}
