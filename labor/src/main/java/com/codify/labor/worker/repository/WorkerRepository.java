package com.codify.labor.worker.repository;

import com.codify.labor.worker.model.WorkerModel;
import com.codify.labor.address.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel, Long> {
    boolean existsByAddress(AddressModel address);
}
