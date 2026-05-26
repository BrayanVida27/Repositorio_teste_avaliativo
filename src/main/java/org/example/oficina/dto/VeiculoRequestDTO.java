package org.example.oficina.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.oficina.model.Cliente;

public record VeiculoRequestDTO(

        //TODO: colocar validações de entrada de dados
        @NotBlank
        String placa,

        @NotBlank
        String modelo,

        @NotNull
        Integer ano,

        @NotNull
        Long idCliente
) {
        public Cliente Cliente() {
            return Cliente();
        }
}
