package com.codify.labor.enterprise.service;

import com.codify.labor.address.model.AddressModel;
import com.codify.labor.address.repository.AddressRepository;
import com.codify.labor.address.service.ViaCepService;
import com.codify.labor.enterprise.dto.EnterpriseRequestDTO;
import com.codify.labor.enterprise.dto.EnterpriseResponseDTO;
import com.codify.labor.enterprise.model.EnterpriseModel;
import com.codify.labor.enterprise.repository.EnterpriseRepository;
import com.codify.labor.worker.exceptions.WorkerNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    public List<EnterpriseResponseDTO> getAllEnterprises() {
        return enterpriseRepository.findAll().stream().map(EnterpriseResponseDTO::new)
                .toList();
    }


    public EnterpriseResponseDTO createEnterprise(EnterpriseRequestDTO enterpriseRequestDTO) {
       return salvarClienteComCep(enterpriseRequestDTO);
    }

    @Transactional
    public void deleteEnterprise(Long id) {
        EnterpriseModel deletedEnterprise = enterpriseRepository.findById(id).orElseThrow(() -> new WorkerNotFoundException(
                "Enterprise" +
                " " +
                "not found."));
        AddressModel address = deletedEnterprise.getAddress();
        enterpriseRepository.delete(deletedEnterprise);
        if (address != null && !enterpriseRepository.existsByAddress(address)) {
            addressRepository.delete(address);
        }
    }

    private EnterpriseResponseDTO salvarClienteComCep(EnterpriseRequestDTO enterpriseRequestDTO) {
        String cep = enterpriseRequestDTO.address().cep();

        AddressModel address = addressRepository.findById(cep)
                .orElseGet(() -> {
                    AddressModel newAddress = viaCepService.consultarCep(cep);
                    return addressRepository.save(newAddress);
                });

        EnterpriseModel enterprise = new EnterpriseModel();
        enterprise.setUsername(enterpriseRequestDTO.username());
        enterprise.setCnpj(enterpriseRequestDTO.cnpj());
        enterprise.setEmail(enterpriseRequestDTO.photo_url());
        enterprise.setPassword(enterpriseRequestDTO.email());
        enterprise.setPhoto_url(enterpriseRequestDTO.password());
        enterprise.setAddress(address);

        EnterpriseModel enterpriseSaved = enterpriseRepository.save(enterprise);
        return new EnterpriseResponseDTO(enterpriseSaved);
    }

}
