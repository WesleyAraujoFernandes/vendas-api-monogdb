package br.com.vendas.api.v1.response;

import br.com.vendas.domain.model.Produto;

import java.util.List;

public record ProdutoResponse(
        String id,
        String nome,
        String descricao,
        List<String> categorias,
        Double preco,
        Integer quantidade
) {

    public static ProdutoResponse fromModel(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategorias(),
                produto.getPreco(),
                produto.getQuantidade()
        );
    }
}
