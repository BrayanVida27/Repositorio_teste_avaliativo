package org.example.oficina.dto;

import jakarta.validation.constraints.Email;

//TODO: colocar dados trazidos no response
public record ClienteResponseDTO (
        Long idCliente,
        String nome,
        String telefone,
        String email


){
}
