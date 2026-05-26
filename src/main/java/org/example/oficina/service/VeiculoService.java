package org.example.oficina.service;

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

import static java.util.stream.Collectors.toList;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<VeiculoResponseDTO> listarTodos() {
        return veiculoRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public VeiculoResponseDTO buscarPorId(Long idVeiculo) {
        Veiculo veiculo = veiculoRepository.findById(idVeiculo)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veículo não encontrado"));

        return converterParaResponse(veiculo);
    }

    public VeiculoResponseDTO cadastrar(VeiculoRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.idCliente())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));
        //TODO: adicionar a exception

        Veiculo veiculo = new Veiculo();

        veiculo.setPlaca(dto.placa());
        veiculo.setModelo(dto.modelo());
        veiculo.setAno(dto.ano());
        veiculo.setCliente(dto.Cliente());

        Veiculo salvo = veiculoRepository.save(veiculo);

        return converterParaResponse(salvo);
    }

    public VeiculoResponseDTO atualizar(Long idVeiculo, VeiculoRequestDTO dto) {
        Veiculo veiculo = veiculoRepository.findById(idVeiculo)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veiculo não encontrado"));

        //TODO: adicionar a exception

        Cliente cliente = clienteRepository.findById(dto.idCliente())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado"));
        //TODO: adicionar a exception

        veiculo.setPlaca(dto.placa());
        veiculo.setModelo(dto.modelo());
        veiculo.setAno(dto.ano());
        veiculo.setCliente(dto.Cliente());

        Veiculo atualizado = veiculoRepository.save(veiculo);

        return converterParaResponse(atualizado);
    }
    //TODO: adicionar a exception
    public Optional<Veiculo> deletar(Long idVeiculo) {
        Veiculo veiculo = veiculoRepository.findById(idVeiculo)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veiculo não encontrado"));
        return veiculoRepository.findById(idVeiculo);

        //TODO: chamar método de deletar do repository
    }

    public List<VeiculoResponseDTO> filtrarPorPlaca(String placa) {
        return veiculoRepository.findByPlacaContainingIgnoreCase(placa)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }



    //TODO: fazer os gets de "veiculo" conforme o que deve aparecer no response
    private VeiculoResponseDTO converterParaResponse(Veiculo veiculo) {
        return new VeiculoResponseDTO(
                veiculo.getIdVeiculo(),
                veiculo.getPlaca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCliente().getIdCliente()

        );
    }


}
