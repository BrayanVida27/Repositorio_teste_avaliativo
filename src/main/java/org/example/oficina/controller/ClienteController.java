package org.example.oficina.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.oficina.dto.ClienteRequestDTO;
import org.example.oficina.dto.ClienteResponseDTO;

import org.example.oficina.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "Rotas para gerenciamento de clientes")
@RestController
@RequestMapping("/clientes")
public class ClienteController {



        @Autowired
        private VeiculoService service;

        @Operation(summary = "Lista todos os clientes")
        @GetMapping
        public List<ClienteResponseDTO> listar() {
            return service.listarTodos();
        }

        @Operation(summary = "Busca um clientes por id")
        @GetMapping("/{idCliente}")
        public ClienteResponseDTO buscarPorId(@PathVariable Long idCliente) {
            return service.buscarPorId(idCliente);
        }

        @Operation(summary = "Cadastra um novo clientes")
        @PostMapping
        public ClienteResponseDTO cadastrar(@RequestBody @Valid ClienteRequestDTO dto) {
            //TODO: usar a validação de dados
            return service.cadastrar(dto);
        }

        @Operation(summary = "Atualiza um clientes existente")
        @PutMapping("/{idCliente}")
        public ClienteResponseDTO atualizar(@PathVariable Long idCliente, @RequestBody ClienteRequestDTO dto) {
            return service.atualizar(idCliente, dto);
        }

        @Operation(summary = "Remove um clientes")
        @DeleteMapping("/{idCliente}")
        public void deletar(@PathVariable Long idVeiculo) {
            service.deletar(idVeiculo);
        }

    }

