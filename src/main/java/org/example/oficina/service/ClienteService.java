package org.example.oficina.service;

import org.example.oficina.dto.ClienteRequestDTO;
import org.example.oficina.dto.ClienteResponseDTO;
import org.example.oficina.dto.VeiculoRequestDTO;
import org.example.oficina.dto.VeiculoResponseDTO;
import org.example.oficina.exception.RecursoNaoEncontradoException;
import org.example.oficina.model.Cliente;
import org.example.oficina.model.Veiculo;
import org.example.oficina.repository.ClienteRepository;
import org.example.oficina.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteResponseDTO> listarTodos() {
        return ClienteRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public ClienteResponseDTO buscarPorId(Long idCliente) {
        Cliente cliente = veiculoRepository.findById(idCliente)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veículo não encontrado"));

        return converterParaResponse(Cliente);
    }

    public VeiculoResponseDTO cadastrar(VeiculoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.idCliente())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));
        //TODO: adicionar a exception

        Cliente cliente = new Cliente();

              cliente.setNome(dto.nome());
              cliente.setTelefone(dto.telefone());
              cliente.setEmail(dto.email());



        Cliente salvo = clienteRepository.save(Cliente);

        return converterParaResponse(salvo);
    }

    public ClienteResponseDTO atualizar(Long idCliente, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));

        //TODO: adicionar a exception

        Cliente cliente = clienteRepository.findById(dto.idCliente())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));
        //TODO: adicionar a exception

        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setEmail(dto.email());


        Cliente atualizado = clienteRepository.save(idCliente);

        return converterParaResponse(atualizado);
    }
    //TODO: adicionar a exception
    public Optional<Cliente> deletar(Long idCliente) {
    Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));
        return clienteRepository.findById(idCliente);

        //TODO: chamar método de deletar do repository
    }



    //TODO: fazer os gets de "veiculo" conforme o que deve aparecer no response
    private ClienteResponseDTO converterParaResponse(Cliente cliente) {
        return new ClienteResponseDTO(

        cliente.getNome(Cliente),
        cliente.getTelefone(),
        cliente.getEmail()

        );
    }
}
