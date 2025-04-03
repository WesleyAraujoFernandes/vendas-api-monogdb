package br.com.vendas.api.v1.request;

import br.com.vendas.domain.model.Categoria;

public record AtualizarCategoriaRequest(
        String nome,
        String descricao
) {

    public static Categoria toModel(AtualizarCategoriaRequest request) {
        return Categoria.novaCategoria(request.nome, request.descricao);
    }
}
