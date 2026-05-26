package org.example.oficina.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrdemServicoResponseDTO(
        Long idOrdemServico,
        String descricaoProblema,
        String status,
        Double valorServico
) {
}
