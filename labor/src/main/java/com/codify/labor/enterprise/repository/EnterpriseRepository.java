package com.codify.labor.enterprise.repository;

import com.codify.labor.address.model.AddressModel;
import com.codify.labor.enterprise.model.EnterpriseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<EnterpriseModel, Long> {
    boolean existsByAddress(AddressModel address);

}
