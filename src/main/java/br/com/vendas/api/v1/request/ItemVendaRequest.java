package br.com.vendas.api.v1.request;

import br.com.vendas.domain.vo.ItemVenda;

public record ItemVendaRequest(
        String produtoId,
        Integer quantidade
) {

    public static ItemVenda toModel(ItemVendaRequest request) {
        return ItemVenda.novoItemVenda(
                request.produtoId(),
                null,
                null,
                request.quantidade(),
                null
        );
    }
}
