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
    private final ClienteService clienteService;
    private final ProdutoRepository produtoRepository;

    public VendaService(VendaRepository vendaRepository, ClienteService clienteService,
                        ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteService = clienteService;
        this.produtoRepository = produtoRepository;
    }

    public Venda cadastrar(Venda venda) {

        clienteService.buscarPorId(venda.getClienteId());

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

    public void adicionarItemVenda(String vendaId, ItemVenda itemVenda) {

        final var venda = vendaRepository.findById(vendaId)
                .orElseThrow(() -> new IllegalArgumentException("Venda não encontrada"));

        final var produto = produtoRepository.findById(itemVenda.getProdutoId())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        itemVenda.atualizarInformaces(
                produto.getNome(),
                produto.getPreco(),
                itemVenda.getQuantidade()
        );

        venda.adicionarItem(itemVenda);

        vendaRepository.save(venda);
    }

    public void removerItemVenda(String vendaId, ItemVenda itemVenda) {

        if (itemVenda.getQuantidade() <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }

        final var venda = vendaRepository.findById(vendaId)
                .orElseThrow(() -> new IllegalArgumentException("Venda não encontrada"));

        produtoRepository.findById(itemVenda.getProdutoId())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        venda.removerItem(itemVenda);

        vendaRepository.save(venda);
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
