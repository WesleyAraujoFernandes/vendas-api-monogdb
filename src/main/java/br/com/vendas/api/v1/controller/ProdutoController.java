package br.com.vendas.api.v1.controller;

import br.com.vendas.api.v1.request.AtualizarProdutoRequest;
import br.com.vendas.api.v1.request.CadastrarProdutoRequest;
import br.com.vendas.api.v1.response.AtualizarProdutoResponse;
import br.com.vendas.api.v1.response.BuscarProdutoPorIdResponse;
import br.com.vendas.api.v1.response.CadastrarProdutoResponse;
import br.com.vendas.api.v1.response.ProdutoResponse;
import br.com.vendas.domain.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<CadastrarProdutoResponse> cadastrar(@RequestBody CadastrarProdutoRequest request) {
        final var produto = produtoService.cadastrar(CadastrarProdutoRequest.toModel(request));
        return ResponseEntity.ok(CadastrarProdutoResponse.fromModel(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarProdutoPorIdResponse> buscarPorId(@PathVariable String id) {
        final var produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(BuscarProdutoPorIdResponse.fromModel(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listar(@RequestParam(required = false) String nome) {
        final var produtos = produtoService.listar(nome);
        return ResponseEntity.ok(produtos.stream().map(ProdutoResponse::fromModel).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtualizarProdutoResponse> atualizar(@PathVariable String id, @RequestBody AtualizarProdutoRequest request) {
        final var produto = produtoService.atualizar(id, AtualizarProdutoRequest.toModel(request));
        return ResponseEntity.ok(AtualizarProdutoResponse.fromModel(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        produtoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
