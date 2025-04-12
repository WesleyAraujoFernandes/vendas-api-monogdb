package br.com.vendas.api.v1.openapi;

import br.com.vendas.api.v1.request.AtualizarClienteRequest;
import br.com.vendas.api.v1.request.CadastrarClienteRequest;
import br.com.vendas.api.v1.response.AtualizarClienteResponse;
import br.com.vendas.api.v1.response.BuscarClientePorIdResponse;
import br.com.vendas.api.v1.response.CadastrarClienteResponse;
import br.com.vendas.api.v1.response.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "Gerencia os clientes")
public interface ClienteOpenAPI {

    @PostMapping
    @Operation(summary = "Cadastra um cliente")
    @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<CadastrarClienteResponse> cadastrar(@RequestBody CadastrarClienteRequest request);

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um cliente")
    @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<AtualizarClienteResponse> atualizar(@PathVariable String id, @RequestBody AtualizarClienteRequest request);

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma cliente por ID")
    @ApiResponse(responseCode = "200", description = "Cliente buscado com sucesso")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<BuscarClientePorIdResponse> buscarPorId(@PathVariable String id);

    @GetMapping
    @Operation(summary = "Lista os clientes")
    @ApiResponse(responseCode = "200", description = "Clientes listados com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @Parameter(name = "nome", description = "Nome do cliente para busca", example = "João")
    ResponseEntity<List<ClienteResponse>> listar(@RequestParam(required = false, defaultValue = "") String nome);

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um cliente")
    @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso!")
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<Void> deletarPorId(@PathVariable String id);
}