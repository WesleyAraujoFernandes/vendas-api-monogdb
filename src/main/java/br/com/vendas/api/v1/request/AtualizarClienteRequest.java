package br.com.vendas.api.v1.request;

import br.com.vendas.domain.model.Cliente;
import br.com.vendas.domain.vo.Endereco;

public record AtualizarClienteRequest(
        String nome,
        String cpf,
        Endereco endereco
) {

    public static Cliente toModel(AtualizarClienteRequest request) {
        return Cliente.novoCliente(
                request.nome(),
                request.cpf(),
                request.endereco()
        );
    }
}
