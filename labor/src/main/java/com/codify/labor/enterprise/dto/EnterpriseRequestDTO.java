package com.codify.labor.enterprise.dto;

import com.codify.labor.address.dto.AddressRequestDTO;

public record EnterpriseRequestDTO(
        Long id,
        String username,
        String cnpj,
        String photo_url,
        String email,
        String password,
        AddressRequestDTO address
) {
}
