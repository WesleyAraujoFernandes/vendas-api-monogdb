package br.com.vendas.api.v1.response;

import br.com.vendas.domain.model.Categoria;

public record BuscarCategoriaPorIdResponse(
        String id,
        String nome,
        String descricao
) {

    public static BuscarCategoriaPorIdResponse fromModel(Categoria categoria) {
        return new BuscarCategoriaPorIdResponse(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
