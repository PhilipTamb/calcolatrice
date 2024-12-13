package com.example.calcolatrice.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class ReportControllerAdvice {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> noDataFoundExceptionHandler(NoDataFoundException e){

        HashMap<String, Object> body = new HashMap<>();

        body.put("timestamp", LocalDateTime.now());
        body.put("CODE_ERROR", "1000");
        body.put("message", "Non è stato trovato l'elemento richiesto");
    }
}
