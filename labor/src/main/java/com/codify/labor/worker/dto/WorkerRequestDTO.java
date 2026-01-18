package com.codify.labor.worker.dto;

import com.codify.labor.address.dto.AddressRequestDTO;

public record WorkerRequestDTO(
        Long id,
        String allName,
        String username,
        String cpf,
        String photo_url,
        String email,
        String password,
        AddressRequestDTO address

) {}
