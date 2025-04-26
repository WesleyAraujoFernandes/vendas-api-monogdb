package br.com.vendas.api.v1.response;

import br.com.vendas.domain.model.Venda;
import br.com.vendas.domain.vo.ItemVenda;

import java.time.LocalDateTime;
import java.util.List;

public record VendaResponse(
        String id,
        String clienteId,
        LocalDateTime data,
        Double valor,
        String status,
        List<ItemVenda> itens
) {

    public static VendaResponse fromModel(Venda venda) {
        return new VendaResponse(
                venda.getId(),
                venda.getClienteId(),
                venda.getData(),
                venda.getValor(),
                venda.getStatus().name(),
                venda.getItems()
        );
    }
}
