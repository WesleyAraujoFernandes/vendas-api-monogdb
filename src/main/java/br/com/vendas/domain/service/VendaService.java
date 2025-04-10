package br.com.vendas.domain.service;

import br.com.vendas.domain.model.Produto;
import br.com.vendas.domain.model.Venda;
import br.com.vendas.domain.repository.ClienteRepository;
import br.com.vendas.domain.repository.ProdutoRepository;
import br.com.vendas.domain.repository.VendaRepository;
import br.com.vendas.domain.vo.ItemVenda;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public VendaService(VendaRepository vendaRepository, ClienteRepository clienteRepository,
                        ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public Venda cadastrar(Venda venda) {

        clienteRepository.findById(venda.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        venda.agruparItens();

        final var produtos = produtoRepository.findAllById(venda.getItems().stream()
                .map(ItemVenda::getProdutoId)
                .toList());

        final var totalDeProdutosInformados = venda.getItems().size();
        final var totalDeProdutosEncontrados = produtos.size();

        if (totalDeProdutosInformados != totalDeProdutosEncontrados) {
            throw new IllegalArgumentException("Um ou mais produtos não encontrados");
        }

        atualizarInformacoesDosItensDaVenda(venda, produtos);

        venda.calcularValor();

        return vendaRepository.save(venda);
    }

    private void atualizarInformacoesDosItensDaVenda(Venda venda, List<Produto> produtos) {
        Map<String, Produto> produtosMap = produtos.stream()
                .collect(Collectors.toMap(Produto::getId, Function.identity()));

        venda.getItems().forEach(item -> {
            Produto produto = produtosMap.get(item.getProdutoId());

            item.setNome(produto.getNome());
            item.setPreco(produto.getPreco());
            item.setPrecoTotal(produto.getPreco() * item.getQuantidade());
        });
    }
}
