package com.example.calcolatrice.Service;

import com.example.calcolatrice.Model.Calcolatrice;
import com.example.calcolatrice.Repository.CalcolatriceRepository;
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
