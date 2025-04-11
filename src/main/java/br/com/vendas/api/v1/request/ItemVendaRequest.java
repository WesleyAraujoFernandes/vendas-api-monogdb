package br.com.vendas.api.v1.request;

public record ItemVendaRequest(
        String produtoId,
        Integer quantidade
) {
}
