package br.com.vendas.api.v1.response;

import br.com.vendas.domain.model.Cliente;
import br.com.vendas.domain.vo.Endereco;

public record AtualizarClienteResponse(
        String id,
        String nome,
        String cpf,
        Endereco endereco
) {

    public static AtualizarClienteResponse fromModel(Cliente cliente) {
        return new AtualizarClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                Endereco.novoEndereco(
                        cliente.getEndereco().getCep(),
                        cliente.getEndereco().getUf(),
                        cliente.getEndereco().getCidade(),
                        cliente.getEndereco().getBairro(),
                        cliente.getEndereco().getLogradouro(),
                        cliente.getEndereco().getComplemento(),
                        cliente.getEndereco().getNumero()
                )
        );
    }
}
