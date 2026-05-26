package org.example.oficina.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrdemServicoRequestDTO(

        @NotBlank
        String descricaoProblema,

        @NotBlank
        String status,

        @NotNull
        Double valorServico
) {
}