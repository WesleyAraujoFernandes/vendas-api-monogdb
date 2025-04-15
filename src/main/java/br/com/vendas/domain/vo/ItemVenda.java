package br.com.vendas.domain.vo;

public class ItemVenda {

    private String produtoId;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private Double precoTotal;

    public ItemVenda(String produtoId, String nome, Double preco, Integer quantidade, Double precoTotal) {
        this.produtoId = produtoId;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
    }

    public static ItemVenda novoItemVenda(String produtoId, String nome, Double preco,
                                          Integer quantidade, Double precoTotal) {
        return new ItemVenda(produtoId, nome, preco, quantidade, precoTotal);
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

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
