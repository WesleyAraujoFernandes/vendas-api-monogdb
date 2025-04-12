package br.com.vendas.api.v1.request;

import br.com.vendas.domain.model.Venda;
import br.com.vendas.domain.vo.ItemVenda;

import java.util.List;

public record CadastrarVendaRequest(
        String clienteId,
        List<ItemVendaRequest> itens
) {

    public static Venda aPartirDe(CadastrarVendaRequest request) {
        return Venda.novaVenda(
                request.clienteId(),
                request.itens().stream()
                        .map(item -> new ItemVenda(
                                item.produtoId(),
                                null,
                                null,
                                item.quantidade(),
                                null
                        ))
                        .toList()
        );
    }
}
