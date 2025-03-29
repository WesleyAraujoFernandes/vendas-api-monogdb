package br.com.vendas.domain.repository;

import br.com.vendas.domain.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
