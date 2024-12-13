package com.example.calcolatrice.handler;

import com.example.calcolatrice.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class UtenteControllerAdvice {
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> noDataFoundExceptionHandler(NoDataFoundException e){
        HashMap<String, Object> body = new HashMap<>();

        // data e ora di quando l'errore si è presentato
        body.put("timestamp", LocalDateTime.now());
        // codice di errore
        body.put("code_error", "1000");
        body.put("message", "non è stato trovato l'elemento richiesto");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
