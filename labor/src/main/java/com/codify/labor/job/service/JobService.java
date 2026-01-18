package com.codify.labor.job.service;

import com.codify.labor.job.dto.JobRequestDTO;
import com.codify.labor.job.dto.JobResponseDTO;
import com.codify.labor.job.model.JobModel;
import com.codify.labor.job.repository.JobRepository;
import com.codify.labor.worker.exceptions.WorkerNotFoundException;
import com.codify.labor.enterprise.model.EnterpriseModel;
import com.codify.labor.enterprise.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    /*
     * get jobs ------
     */
    public List<JobResponseDTO> getAllJobs() {
        return jobRepository.findAll().stream().map(JobResponseDTO::new).toList();
    }

    public List<JobResponseDTO> getJobByEnterprise(Long enterpriseId) {
        return jobRepository.findByEnterpriseId(enterpriseId).stream().map(JobResponseDTO::new).toList();
    }

    public Optional<JobResponseDTO> getJobById(Long id) {
        return jobRepository.findById(id)
                .map(JobResponseDTO::new);
    }

    public JobResponseDTO createJob(JobRequestDTO jobRequestDTO) {
        EnterpriseModel enterprise = enterpriseRepository.findById(jobRequestDTO.enterpriseId())
                .orElseThrow(() -> new WorkerNotFoundException("Enterprise with id " + jobRequestDTO.enterpriseId() + " not found"));

        JobModel job = new JobModel();
        job.setJobTittle(jobRequestDTO.jobTittle());
        job.setJobDescription(jobRequestDTO.jobDescription());
        job.setJobStartDate(jobRequestDTO.jobStartDate());
        job.setJobEndDate(jobRequestDTO.jobEndDate());
        job.setPaymentValue(jobRequestDTO.paymentValue());
        job.setEnterprise(enterprise);

        JobModel jobCreated = jobRepository.save(job);
        return new JobResponseDTO(jobCreated);

    }

    public void deleteJob(Long id) {
        JobModel job = jobRepository.findById(id).orElseThrow(() -> new WorkerNotFoundException("Job not found"));
        jobRepository.delete(job);
    }

}
