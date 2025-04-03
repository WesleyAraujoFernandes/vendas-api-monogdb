package br.com.vendas.api.v1.controller;

import br.com.vendas.api.v1.request.AtualizarCategoriaRequest;
import br.com.vendas.api.v1.request.CadastrarCategoriaRequest;
import br.com.vendas.api.v1.request.CategoriaResponse;
import br.com.vendas.api.v1.response.AtualizarCategoriaResponse;
import br.com.vendas.api.v1.response.BuscarCategoriaPorIdResponse;
import br.com.vendas.api.v1.response.CadastrarCategoriaResponse;
import br.com.vendas.domain.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CadastrarCategoriaResponse> cadastrar(@RequestBody CadastrarCategoriaRequest request) {
        final var categoria = categoriaService.cadastrar(CadastrarCategoriaRequest.toModel(request));
        return ResponseEntity.ok(CadastrarCategoriaResponse.fromModel(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtualizarCategoriaResponse> atualizar(@PathVariable String id, @RequestBody AtualizarCategoriaRequest request) {
        final var categoria = categoriaService.atualizar(id, AtualizarCategoriaRequest.toModel(request));
        return ResponseEntity.ok(AtualizarCategoriaResponse.fromModel(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarCategoriaPorIdResponse> buscarPorId(@PathVariable String id) {
        final var categoria = categoriaService.buscarPorId(id);
        return ResponseEntity.ok(BuscarCategoriaPorIdResponse.fromModel(categoria));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listar() {
        final var categorias = categoriaService.listar();
        return ResponseEntity.ok(categorias.stream().map(CategoriaResponse::fromModel).toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        categoriaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
