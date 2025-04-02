package br.com.vendas.api.v1.request;

import br.com.vendas.domain.model.Categoria;

public record CategoriaResponse(
        String id,
        String nome,
        String descricao
) {

    public static CategoriaResponse fromModel(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
