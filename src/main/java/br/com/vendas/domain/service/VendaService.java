package br.com.vendas.domain.service;

import br.com.vendas.domain.model.Venda;
import br.com.vendas.domain.repository.ClienteRepository;
import br.com.vendas.domain.repository.ProdutoRepository;
import br.com.vendas.domain.repository.VendaRepository;
import br.com.vendas.domain.vo.ItemVenda;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public VendaService(VendaRepository vendaRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public Venda cadastrar(Venda venda) {
        final var cliente = clienteRepository.existsById(venda.getClienteId());

        if (!cliente) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        final var produtos = produtoRepository.findAllById(venda.getItems().stream()
                .map(ItemVenda::getProdutoId)
                .toList());

        if (produtos.size() != venda.getItems().size()) {
            throw new IllegalArgumentException("Um ou mais produtos não encontrados");
        }

        final var vendaSalva = vendaRepository.save(venda);

        return vendaSalva;
    }
}
