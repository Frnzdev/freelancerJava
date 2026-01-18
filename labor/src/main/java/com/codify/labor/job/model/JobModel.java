package com.codify.labor.job.model;

import com.codify.labor.enterprise.model.EnterpriseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "job_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTittle;
    private String jobDescription;
    private LocalDate jobStartDate;
    private LocalDate jobEndDate;
    private Double paymentValue;
    @ManyToOne
    @JoinColumn(name = "enterprise_id", nullable = false)
    private EnterpriseModel enterprise;

}
