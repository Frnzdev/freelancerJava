package com.codify.labor.job.dto;

import java.time.LocalDate;

public record JobRequestDTO(
        Long id,
        String jobTittle,
        String jobDescription,
        LocalDate jobStartDate,
        LocalDate jobEndDate,
        Double paymentValue,
        Long enterpriseId
) {
}
