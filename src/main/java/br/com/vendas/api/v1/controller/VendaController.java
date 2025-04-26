package br.com.vendas.api.v1.controller;

import br.com.vendas.api.v1.openapi.VendaOpenAPI;
import br.com.vendas.api.v1.request.CadastrarVendaRequest;
import br.com.vendas.api.v1.request.ItemVendaRequest;
import br.com.vendas.api.v1.response.CadastrarVendaResponse;
import br.com.vendas.api.v1.response.VendaResponse;
import br.com.vendas.domain.filter.VendaFilter;
import br.com.vendas.domain.pagination.Pagination;
import br.com.vendas.domain.service.VendaQueryService;
import br.com.vendas.domain.service.VendaService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vendas")
public class VendaController implements VendaOpenAPI {

    private final VendaService vendaService;
    private final VendaQueryService vendaQueryService;

    public VendaController(VendaService vendaService, VendaQueryService vendaQueryService) {
        this.vendaService = vendaService;
        this.vendaQueryService = vendaQueryService;
    }

    public ResponseEntity<CadastrarVendaResponse> cadastrar(CadastrarVendaRequest request) {
        final var venda = vendaService.cadastrar(CadastrarVendaRequest.aPartirDe(request));
        return ResponseEntity.ok().body(new CadastrarVendaResponse(venda.getId()));
    }

    @Override
    public ResponseEntity<Void> adicionarItemVenda(String vendaId, ItemVendaRequest request) {
        vendaService.adicionarItemVenda(vendaId, ItemVendaRequest.toModel(request));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> removerItemVenda(String vendaId, ItemVendaRequest request) {
        vendaService.removerItemVenda(vendaId, ItemVendaRequest.toModel(request));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Pagination<VendaResponse>> listar(VendaFilter vendaFilter) {
        final var vendas = vendaQueryService.listar(vendaFilter);
        return ResponseEntity.ok().body(
                new Pagination<>(
                        vendas.pagina(),
                        vendas.porPagina(),
                        vendas.total(),
                        vendas.resultado().stream()
                                .map(VendaResponse::fromModel)
                                .toList()
                )
        );
    }
}
