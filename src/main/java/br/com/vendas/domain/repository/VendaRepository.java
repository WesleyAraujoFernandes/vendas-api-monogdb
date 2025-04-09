package br.com.vendas.domain.repository;

import br.com.vendas.domain.model.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendaRepository extends MongoRepository<Venda, String> {
}
