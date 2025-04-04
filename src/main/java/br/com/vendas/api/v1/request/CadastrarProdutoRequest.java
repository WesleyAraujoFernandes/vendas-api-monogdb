package br.com.vendas.api.v1.request;

import br.com.vendas.domain.model.Produto;

import java.util.List;

public record CadastrarProdutoRequest(
        String nome,
        String descricao,
        List<String> categorias,
        String codigoDeBarras,
        Double preco,
        Integer quantidade
) {

    public static Produto toModel(CadastrarProdutoRequest request) {
        return Produto.novoProduto(
                request.nome(),
                request.descricao(),
                request.categorias(),
                request.codigoDeBarras(),
                request.preco(),
                request.quantidade()
        );
    }
}
