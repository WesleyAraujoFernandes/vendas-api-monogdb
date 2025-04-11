package br.com.vendas.api.v1.request;

import br.com.vendas.domain.vo.ItemVenda;

import java.util.List;

public record CadastrarVendaRequest(
        String clientId,
        List<ItemVenda> itens
) {
}
