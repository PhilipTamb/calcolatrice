package com.example.calcolatrice.service;

import com.example.calcolatrice.dto.ReportDTO;
import com.example.calcolatrice.model.Report;
import com.example.calcolatrice.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<ReportDTO> getAllReports() {
        return reportRepository.findAll()
                .stream()
                .map(this::modelToDto)
                .toList();
    }

    @Override
    public ReportDTO getReportByUuid(String uuid) {
        return modelToDto(reportRepository.findByUuid(uuid).
                orElseThrow(NoDataFoundException::new));
    }

    @Override
    public List<ReportDTO> getReportsWithMoreThanNUtillizzi(int threshold) {
        return reportRepository.findByNUtilizziGreaterThan(threshold)
                .stream()
                .map(this::modelToDto)
                .toList();
    }

    @Override
    public ReportDTO saveReport(ReportDTO report) {
        report.setUuid( String.valueOf(UUID.randomUUID()));
        return modelToDto(reportRepository.save( dtoToModel( report ) ));
    }

    @Override
    public void deleteReportByUuid(String uuid) {
        Report reportToDelete = reportRepository.findByUuid(uuid)
                        .orElseThrow(NoDataFoundException::new);
        reportRepository.delete(reportToDelete);
    }

    @Override
    public ReportDTO updateNumberUses(String uuid) {
        ReportDTO reportToUpdate = modelToDto(reportRepository.findByUuid(uuid).get());
        reportToUpdate.setNUtilizzi(reportToUpdate.getNUtilizzi() + 1); //aggiorno di 1 il numero di utilizzi
        return reportToUpdate;
    }


    // Metodo per convertire un Report in un ReportDTO
    public ReportDTO modelToDto(Report report) {
        // Utilizza il builder per creare un ReportDTO
        return ReportDTO.builder()
                .uuid(report.getUuid())
                .userUuid(report.getUserUuid())
                .nUtilizzi(report.getNUtilizzi())
                .build();
    }

    // Metodo per convertire un ReportDTO in un Report
    public Report dtoToModel(ReportDTO reportDTO) {
        // Utilizza il builder per creare un Report
        return Report.builder()
                .uuid(reportDTO.getUuid())
                .userUuid(reportDTO.getUserUuid())
                .nUtilizzi(reportDTO.getNUtilizzi())
                .build();
    }
}
