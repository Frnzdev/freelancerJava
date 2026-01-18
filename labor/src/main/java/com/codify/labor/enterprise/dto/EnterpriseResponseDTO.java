package com.codify.labor.enterprise.dto;

import com.codify.labor.address.dto.AddressResponseDTO;
import com.codify.labor.enterprise.model.EnterpriseModel;

public record EnterpriseResponseDTO(
        Long id,
        String username,
        String cnpj,
        String photo_url,
        String email,
        String password,
        AddressResponseDTO address

) {
    public EnterpriseResponseDTO(EnterpriseModel enterprise){
        this(
                enterprise.getId(),
                enterprise.getUsername(),
                enterprise.getCnpj(),
                enterprise.getPhoto_url(),
                enterprise.getEmail(),
                enterprise.getPassword(),
                enterprise.getAddress() != null ? new AddressResponseDTO(enterprise.getAddress()) : null);
    }
}
