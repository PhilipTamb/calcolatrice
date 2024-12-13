package com.example.calcolatrice.service;

import com.example.calcolatrice.dto.ReportDTO;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    // Recupera tutti i report
    List<ReportDTO> getAllReports();

    // Trova un report tramite il campo UUID
    ReportDTO getReportByUuid(String uuid);

    // Trova tutti i report con un numero di utilizzi maggiore del valore specificato
    List<ReportDTO> getReportsWithMoreThanNUtillizzi(int threshold);

    // Salva un report
    ReportDTO saveReport(ReportDTO report);

    // Elimina un report tramite uuid
    void deleteReportByUuid(String uuid);

    // Aggiorna il numero di utilizzi di un report
    ReportDTO updateNumberUses(String uuid);
}
