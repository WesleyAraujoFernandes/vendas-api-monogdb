package br.com.vendas.domain.repository;

import br.com.vendas.domain.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
}
