package org.example.oficina.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoResponseDTO(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idVeiculo,

        @NotBlank
        String placa,

        @NotBlank
        String modelo,

        @NotNull
        Integer ano,

        @NotNull
        Long idCliente

        //TODO: retornar informações do cliente
) {
}
