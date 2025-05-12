package br.com.vendas.api.v1.controller;

import br.com.vendas.api.v1.openapi.ClienteOpenAPI;
import br.com.vendas.api.v1.request.AtualizarClienteRequest;
import br.com.vendas.api.v1.request.CadastrarClienteRequest;
import br.com.vendas.api.v1.response.AtualizarClienteResponse;
import br.com.vendas.api.v1.response.BuscarClientePorIdResponse;
import br.com.vendas.api.v1.response.CadastrarClienteResponse;
import br.com.vendas.api.v1.response.ClienteResponse;
import br.com.vendas.domain.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController implements ClienteOpenAPI {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<CadastrarClienteResponse> cadastrar(@RequestBody CadastrarClienteRequest request) {
        final var cliente = clienteService.cadastrar(CadastrarClienteRequest.toModel(request));
        return ResponseEntity.ok(CadastrarClienteResponse.fromModel(cliente));
    }

    /*
     * public ResponseEntity<CadastrarClienteResponse>
     * cadastrar(CadastrarClienteRequest request) {
     * final var cliente =
     * clienteService.cadastrar(CadastrarClienteRequest.toModel(request));
     * return ResponseEntity.ok(CadastrarClienteResponse.fromModel(cliente));
     * }
     */
    public ResponseEntity<AtualizarClienteResponse> atualizar(String id, AtualizarClienteRequest request) {
        final var cliente = clienteService.atualizar(id, AtualizarClienteRequest.toModel(request));
        return ResponseEntity.ok(AtualizarClienteResponse.fromModel(cliente));
    }

    public ResponseEntity<BuscarClientePorIdResponse> buscarPorId(String id) {
        final var cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(BuscarClientePorIdResponse.fromModel(cliente));
    }

    public ResponseEntity<List<ClienteResponse>> listar(String nome) {
        final var clientes = clienteService.listar(nome);
        return ResponseEntity.ok(clientes.stream().map(ClienteResponse::fromModel).toList());
    }

    public ResponseEntity<Void> deletarPorId(String id) {
        clienteService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
