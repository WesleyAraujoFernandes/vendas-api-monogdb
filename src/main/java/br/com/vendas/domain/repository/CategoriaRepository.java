package br.com.vendas.domain.repository;

import br.com.vendas.domain.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
