package br.com.vendas.api.v1.openapi;

import br.com.vendas.api.v1.request.AtualizarCategoriaRequest;
import br.com.vendas.api.v1.request.CadastrarCategoriaRequest;
import br.com.vendas.api.v1.response.AtualizarCategoriaResponse;
import br.com.vendas.api.v1.response.BuscarCategoriaPorIdResponse;
import br.com.vendas.api.v1.response.CadastrarCategoriaResponse;
import br.com.vendas.api.v1.response.CategoriaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Categorias", description = "Gerencia as categorias")
public interface CategoriaOpenAPI {

    @PostMapping
    @Operation(summary = "Cadastra uma categoria")
    @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<CadastrarCategoriaResponse> cadastrar(@RequestBody CadastrarCategoriaRequest request);

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma categoria")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<AtualizarCategoriaResponse> atualizar(@PathVariable String id, @RequestBody AtualizarCategoriaRequest request);

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma categoria por ID")
    @ApiResponse(responseCode = "200", description = "Categoria buscada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<BuscarCategoriaPorIdResponse> buscarPorId(@PathVariable String id);

    @GetMapping
    @Operation(summary = "Lista as categorias")
    @ApiResponse(responseCode = "200", description = "Categorias listadas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<List<CategoriaResponse>> listar();

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma categoria")
    @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso!")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<Void> deletarPorId(@PathVariable String id);
}
