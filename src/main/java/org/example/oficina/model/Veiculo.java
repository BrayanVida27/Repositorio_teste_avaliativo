package org.example.oficina.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeiculo;

    private String placa;

    private String modelo;

    private Integer ano;


    //TODO: corrigir o relacionamento entre Veiculo e Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;



}
