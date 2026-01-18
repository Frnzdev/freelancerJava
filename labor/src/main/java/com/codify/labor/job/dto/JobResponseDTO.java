package com.codify.labor.job.dto;

import com.codify.labor.enterprise.model.EnterpriseModel;
import com.codify.labor.job.model.JobModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public record JobResponseDTO(
        Long id,
        String jobTittle,
        String jobDescription,
        LocalDate jobStartDate,
        LocalDate jobEndDate,
        Double paymentValue,
        EnterpriseModel enterprise
) {

    public JobResponseDTO(JobModel job) {
        this(
                job.getId(),
                job.getJobTittle(),
                job.getJobDescription(),
                job.getJobStartDate(),
                job.getJobEndDate(),
                job.getPaymentValue(),
                job.getEnterprise()
        );
    }

}
