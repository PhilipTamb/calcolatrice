package com.example.calcolatrice.controller;

import com.example.calcolatrice.dto.ReportDTO;
import com.example.calcolatrice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")  // Path base per il controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    // Endpoint per ottenere tutti i report
    @GetMapping
    public List<ReportDTO> getAllReports() {
        return reportService.getAllReports(); // Restituisce i report
    }

    // Endpoint per ottenere un report specifico tramite UUID
    @GetMapping("/{uuid}")
    public ReportDTO getReportByUuid(@PathVariable String uuid) {
        return reportService.getReportByUuid(uuid); //restituisce il report con l'uuid ricevuto
    }

    // Endpoint per ottenere i report con utilizzi superiori a una soglia
    @GetMapping("/threshold/{threshold}")
    public List<ReportDTO> getReportsWithMoreThanNUtillizzi(@PathVariable int threshold) {
        return reportService.getReportsWithMoreThanNUtillizzi(threshold); // restituisce report con numero di utilizzi > threshold
    }

    // Endpoint per salvare un nuovo report
    @PostMapping
    public ReportDTO saveReport(@RequestBody ReportDTO reportDTO) {
        return reportService.saveReport(reportDTO);
    }

    // Endpoint per eliminare un report tramite UUID
    @DeleteMapping("/{uuid}")
    public void deleteReportByUuid(@PathVariable String uuid) {
        reportService.deleteReportByUuid(uuid);
    }

    // Endpoint per aggiornare il numero di utilizzi di un report
    @PatchMapping("/{uuid}")
    public ReportDTO updateNumberUses(@PathVariable String uuid) {
       return reportService.updateNumberUses(uuid);
    }
}