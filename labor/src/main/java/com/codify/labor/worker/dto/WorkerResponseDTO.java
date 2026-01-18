package com.codify.labor.worker.dto;

import com.codify.labor.worker.model.WorkerModel;
import com.codify.labor.address.dto.AddressResponseDTO;

public record WorkerResponseDTO(
        Long id,
        String allName,
        String username,
        String cpf,
        String photo_url,
        String email,
        String password,
        AddressResponseDTO address

) {

    public WorkerResponseDTO(WorkerModel worker) {
        this(worker.getId(),
                worker.getAllName(),
                worker.getUsername(),
                worker.getCpf(),
                worker.getPhoto_url(),
                worker.getEmail(),
                worker.getPassword(),
                worker.getAddress() != null ? new AddressResponseDTO(worker.getAddress()) : null);
    }
}
