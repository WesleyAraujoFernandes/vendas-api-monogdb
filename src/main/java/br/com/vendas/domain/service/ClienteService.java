package br.com.vendas.domain.service;

import br.com.vendas.domain.model.Cliente;
import br.com.vendas.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(String id, Cliente cliente) {
        final var cli = buscarPorId(id);
        cli.atualizar(cliente.getNome(), cliente.getCpf(), cliente.getEndereco());
        return clienteRepository.save(cli);
    }

    public Cliente buscarPorId(String id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public List<Cliente> listar(String nome) {
        if (StringUtils.hasText(nome)) {
            return clienteRepository.findByNomeContainingIgnoreCase(nome);
        }
        return clienteRepository.findAll();
    }

    public void deletarPorId(String id) {
        clienteRepository.deleteById(id);
    }
}
