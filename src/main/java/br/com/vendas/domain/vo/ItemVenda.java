package br.com.vendas.domain.vo;

public class ItemVenda {

    private String produtoId;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private Double precoTotal;

    public ItemVenda(String produtoId, String nome, Double preco, Integer quantidade) {
        this.produtoId = produtoId;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.precoTotal = preco * quantidade;
    }

    public String getProdutoId() {
        return produtoId;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}
