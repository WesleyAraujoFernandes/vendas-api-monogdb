package br.com.vendas.api.v1.openapi;

import br.com.vendas.api.v1.request.CadastrarVendaRequest;
import br.com.vendas.api.v1.request.ItemVendaRequest;
import br.com.vendas.api.v1.response.CadastrarVendaResponse;
import br.com.vendas.api.v1.response.VendaResponse;

import br.com.vendas.domain.filter.VendaFilter;
import br.com.vendas.domain.pagination.Pagination;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Vendas", description = "Gerencia as vendas")
public interface VendaOpenAPI {

    @PostMapping
    @Operation(summary = "Cadastra uma venda")
    @ApiResponse(responseCode = "201", description = "Venda cadastrada com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<CadastrarVendaResponse> cadastrar(@RequestBody CadastrarVendaRequest request);

    @PostMapping("/{vendaId}/itens/adicionar")
    @Operation(summary = "Adiciona um item na venda")
    @ApiResponse(responseCode = "204", description = "Item adicionado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<Void> adicionarItemVenda(@PathVariable("vendaId") String vendaId, @RequestBody ItemVendaRequest request);

    @PostMapping("/{vendaId}/itens/remover")
    @Operation(summary = "Remove um item da venda")
    @ApiResponse(responseCode = "204", description = "Item removido com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<Void> removerItemVenda(@PathVariable("vendaId") String vendaId, @RequestBody ItemVendaRequest request);

    @GetMapping
    @Operation(summary = "Lista as vendas com base nos parâmetros informados")
    @ApiResponse(responseCode = "200", description = "Vendas listadas com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<Pagination<VendaResponse>> listar(@ModelAttribute VendaFilter vendaFilter);
}
