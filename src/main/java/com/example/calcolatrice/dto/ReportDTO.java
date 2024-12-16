package com.example.calcolatrice.dto;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDTO {

    private String uuid;
    private String userUuid;
    private int nUtilizzi;

}
