package com.codify.labor.worker.model;

import com.codify.labor.address.model.AddressModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "worker_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String allName;
    private String username;
    private String cpf;
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
