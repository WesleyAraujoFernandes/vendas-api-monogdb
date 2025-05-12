package br.com.vendas.domain.repository;

import br.com.vendas.domain.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    List<Cliente> findByNomeContainingIgnoreCase(String nome);

}
