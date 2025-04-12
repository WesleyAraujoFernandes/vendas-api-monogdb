package br.com.vendas.api.v1.openapi;

import br.com.vendas.api.v1.request.CadastrarVendaRequest;
import br.com.vendas.api.v1.response.CadastrarVendaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Vendas", description = "Gerencia as vendas")
public interface VendaOpenAPI {

    @PostMapping
    @Operation(summary = "Cadastra uma venda")
    @ApiResponse(responseCode = "201", description = "Venda cadastrada com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    ResponseEntity<CadastrarVendaResponse> cadastrar(@RequestBody CadastrarVendaRequest request);
}
