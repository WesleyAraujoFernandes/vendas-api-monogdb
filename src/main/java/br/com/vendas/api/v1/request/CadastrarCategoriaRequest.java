package br.com.vendas.api.v1.request;

import br.com.vendas.domain.model.Categoria;

public record CadastrarCategoriaRequest(
        String nome,
        String descricao
) {

    public static Categoria toModel(CadastrarCategoriaRequest request) {
        return Categoria.novaCategoria(request.nome, request.descricao);
    }
}
