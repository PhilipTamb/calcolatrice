package com.example.calcolatrice.Controller;

import com.example.calcolatrice.Model.Calcolatrice;
import com.example.calcolatrice.Service.ICalcolatriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calcolatrice")
public class CalcolatriceController {

    @Autowired
    private ICalcolatriceService iCalcolatriceService;

    @PostMapping
    public Double getResult(@RequestBody Calcolatrice c){
        return iCalcolatriceService.getResult(c);
    }
}
