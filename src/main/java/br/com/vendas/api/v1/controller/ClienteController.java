package br.com.vendas.api.v1.controller;

import br.com.vendas.api.v1.request.AtualizarClienteRequest;
import br.com.vendas.api.v1.request.CadastrarClienteRequest;
import br.com.vendas.api.v1.response.AtualizarClienteResponse;
import br.com.vendas.api.v1.response.CadastrarClienteResponse;
import br.com.vendas.api.v1.response.ClienteResponse;
import br.com.vendas.domain.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<CadastrarClienteResponse> cadastrar(@RequestBody CadastrarClienteRequest request) {
        final var cliente = clienteService.cadastrar(CadastrarClienteRequest.toModel(request));
        return ResponseEntity.ok(CadastrarClienteResponse.fromModel(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtualizarClienteResponse> atualizar(@PathVariable String id, @RequestBody AtualizarClienteRequest request) {
        final var cliente = clienteService.atualizar(id, AtualizarClienteRequest.toModel(request));
        return ResponseEntity.ok(AtualizarClienteResponse.fromModel(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastrarClienteResponse> buscarPorId(@PathVariable String id) {
        final var cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(CadastrarClienteResponse.fromModel(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar(@RequestParam(required = false, defaultValue = "") String nome) {
        final var clientes = clienteService.listar(nome);
        return ResponseEntity.ok(clientes.stream().map(ClienteResponse::fromModel).toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        clienteService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

}
