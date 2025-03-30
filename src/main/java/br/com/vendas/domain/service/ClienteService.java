package br.com.vendas.domain.service;

import br.com.vendas.domain.model.Cliente;
import br.com.vendas.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(String id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public void deletarPorId(String id) {
        clienteRepository.deleteById(id);
    }
}
