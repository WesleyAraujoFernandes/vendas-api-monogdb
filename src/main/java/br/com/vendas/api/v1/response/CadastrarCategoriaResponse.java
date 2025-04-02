package br.com.vendas.api.v1.response;

import br.com.vendas.domain.model.Categoria;

public record CadastrarCategoriaResponse(
        String id,
        String nome,
        String descricao
) {

    public static CadastrarCategoriaResponse fromModel(Categoria categoria) {
        return new CadastrarCategoriaResponse(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
