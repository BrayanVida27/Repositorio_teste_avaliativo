package org.example.oficina.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nome;

    private String telefone;

    private String email;

    public Cliente(){}

        @OneToMany(mappedBy = "veiculo")
        private List<Cliente> clientes;



}
