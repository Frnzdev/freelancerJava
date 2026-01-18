package com.codify.labor.job.controller;

import com.codify.labor.job.dto.JobRequestDTO;
import com.codify.labor.job.dto.JobResponseDTO;
import com.codify.labor.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<JobResponseDTO> getJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/enterprise/{enterpriseId}")
    public List<JobResponseDTO> getJobByEnterpriseId(@PathVariable Long enterpriseId) {
        return jobService.getJobByEnterprise(enterpriseId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDTO> getJobById(@PathVariable Long id) {
        return jobService.getJobById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public JobResponseDTO createJob(@RequestBody JobRequestDTO jobRequestDTO) {
        return jobService.createJob(jobRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JobResponseDTO> deleteJobById(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok().build();
    }

}
