package br.com.vendas.api.v1.controller;

import br.com.vendas.api.v1.openapi.VendaOpenAPI;
import br.com.vendas.api.v1.request.CadastrarVendaRequest;
import br.com.vendas.api.v1.response.CadastrarVendaResponse;
import br.com.vendas.domain.service.VendaService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vendas")
public class VendaController implements VendaOpenAPI {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    public ResponseEntity<CadastrarVendaResponse> cadastrar(CadastrarVendaRequest request) {
        final var venda = vendaService.cadastrar(CadastrarVendaRequest.aPartirDe(request));
        return ResponseEntity.ok().body(new CadastrarVendaResponse(venda.getId()));
    }
}
