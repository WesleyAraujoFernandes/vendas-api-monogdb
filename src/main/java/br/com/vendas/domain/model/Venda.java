package br.com.vendas.domain.model;

import br.com.vendas.domain.vo.ItemVenda;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document(collection = "venda")
public class Venda {

    @Id
    private String id;
    private String clienteId;
    private LocalDateTime data;
    private Double valor;
    private StatusVenda status;
    private List<ItemVenda> items;

    private Venda(String id, String clienteId, Double valor, List<ItemVenda> items) {
        this.id = id;
        this.clienteId = clienteId;
        this.data = LocalDateTime.now();
        this.valor = valor;
        this.status = StatusVenda.ABERTA;
        this.items = items;
    }

    public static Venda novaVenda(String clienteId, List<ItemVenda> items) {
        final var id = UUID.randomUUID().toString();
        final var valor = items.stream()
                .mapToDouble(ItemVenda::getPrecoTotal)
                .sum();
        return new Venda(id, clienteId, valor, items);
    }

    public String getId() {
        return id;
    }

    public List<ItemVenda> getItems() {
        return items;
    }

    public StatusVenda getStatus() {
        return status;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getClienteId() {
        return clienteId;
    }
}
