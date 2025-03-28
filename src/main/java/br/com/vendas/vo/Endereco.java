package br.com.vendas.vo;

public class Endereco {

    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String complemento;
    private String numero;

    public Endereco(String cep, String uf, String cidade, String bairro, String logradouro, String complemento, String numero) {
        this.cep = cep;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }
}
