package br.com.vendas.api.v1.response;

import br.com.vendas.domain.model.Categoria;

public record AtualizarCategoriaResponse(
        String id,
        String nome,
        String descricao
) {

    public static AtualizarCategoriaResponse fromModel(Categoria categoria) {
        return new AtualizarCategoriaResponse(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
