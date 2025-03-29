package br.com.vendas.api.v1.response;

import br.com.vendas.api.v1.request.EnderecoRequest;
import br.com.vendas.domain.model.Cliente;

public record CadastrarClienteResponse(
        String id,
        String nome,
        String cpf,
        EnderecoRequest endereco
) {

    public static CadastrarClienteResponse fromModel(Cliente cliente) {
        return new CadastrarClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                new EnderecoRequest(
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
