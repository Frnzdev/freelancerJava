package com.codify.labor.job.repository;

import com.codify.labor.job.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<JobModel, Long> {
    List<JobModel> findByEnterpriseId(Long enterpriseId);

}
