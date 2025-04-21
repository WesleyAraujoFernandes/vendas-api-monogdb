package br.com.vendas.domain.model;

import br.com.vendas.domain.vo.Endereco;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "cliente")
public class Cliente {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private Endereco endereco;
    private Boolean ativo;

    private Cliente(String nome, String cpf, Endereco endereco) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ativo = true;
    }

    public static Cliente novoCliente(String nome, String cpf, Endereco endereco) {
        return new Cliente(nome, cpf, endereco);
    }

    public Cliente atualizar(String nome, String cpf, Endereco endereco) {
        if (endereco != null) {
            this.endereco = endereco;
        }
        this.nome = nome;
        this.cpf = cpf;
        return this;
    }

    public String getId() {
        return id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
