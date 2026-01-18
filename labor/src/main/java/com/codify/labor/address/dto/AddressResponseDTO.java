package com.codify.labor.address.dto;

import com.codify.labor.address.model.AddressModel;

public record AddressResponseDTO(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        String ibge,
        String gia,
        String ddd,
        String siafi
) {
    public AddressResponseDTO(AddressModel address) {
        this(
                address == null ? null : address.getCep(),
                address == null ? null : address.getLogradouro(),
                address == null ? null : address.getBairro(),
                address == null ? null : address.getLocalidade(),
                address == null ? null : address.getUf(),
                address == null ? null : address.getIbge(),
                address == null ? null : address.getGia(),
                address == null ? null : address.getDdd(),
                address == null ? null : address.getSiafi()
        );
    }
}
