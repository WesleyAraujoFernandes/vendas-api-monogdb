package br.com.vendas.api.v1.response;

import br.com.vendas.domain.model.Produto;

import java.util.List;

public record CadastrarProdutoResponse(
        String id,
        String nome,
        String descricao,
        List<String> categorias,
        String codigoDeBarras,
        Double preco,
        Integer quantidade
) {

    public static CadastrarProdutoResponse fromModel(Produto produto) {
        return new CadastrarProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategorias(),
                produto.getCodigoDeBarras(),
                produto.getPreco(),
                produto.getQuantidade()
        );
    }
}
