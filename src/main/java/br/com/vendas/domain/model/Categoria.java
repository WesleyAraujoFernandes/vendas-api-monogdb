package br.com.vendas.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "categoria")
public class Categoria {

    @Id
    private String id;
    private String nome;
    private String descricao;

    private Categoria(String id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public static Categoria novaCategoria(String nome, String descricao) {
        final var id = UUID.randomUUID().toString();
        return new Categoria(id, nome, descricao);
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
