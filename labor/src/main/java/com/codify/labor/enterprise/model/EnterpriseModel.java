package com.codify.labor.enterprise.model;

import com.codify.labor.address.model.AddressModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "entrprise_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String cnpj;
    private String photo_url;
    private String email;
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "address_cep",
            referencedColumnName = "cep",
            nullable = false
    )
    private AddressModel address;

}

