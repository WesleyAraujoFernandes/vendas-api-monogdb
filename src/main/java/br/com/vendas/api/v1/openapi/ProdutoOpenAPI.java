package br.com.vendas.api.v1.openapi;

import br.com.vendas.api.v1.request.AtualizarProdutoRequest;
import br.com.vendas.api.v1.request.CadastrarProdutoRequest;
import br.com.vendas.api.v1.response.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Produtos", description = "Gerencia os produtos")
public interface ProdutoOpenAPI {

    @PostMapping
    @Operation(summary = "Cadastra um produto")
    @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<CadastrarProdutoResponse> cadastrar(@RequestBody CadastrarProdutoRequest request);

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um produto")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<AtualizarProdutoResponse> atualizar(@PathVariable String id, @RequestBody AtualizarProdutoRequest request);

    @GetMapping("/{id}")
    @Operation(summary = "Busca um produto por ID")
    @ApiResponse(responseCode = "200", description = "Produto buscado com sucesso")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<BuscarProdutoPorIdResponse> buscarPorId(@PathVariable String id);

    @GetMapping
    @Operation(summary = "Lista os produtos")
    @ApiResponse(responseCode = "200", description = "Produtos listados com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @Parameter(name = "nome", description = "Nome do produto para busca", example = "Cerveja")
    ResponseEntity<List<ProdutoResponse>> listar(@RequestParam(required = false, defaultValue = "") String nome);

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um produto")
    @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso!")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<Void> deletarPorId(@PathVariable String id);
}
