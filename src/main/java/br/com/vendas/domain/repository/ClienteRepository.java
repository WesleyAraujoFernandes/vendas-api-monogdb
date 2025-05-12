package br.com.vendas.domain.repository;

import br.com.vendas.domain.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    /*
     * Pode ser feito dessa forma usando @Query
     * 
     * @Query("{'nome': {$regex: ?0, $options: 'i'}}")
     * List<Cliente> buscarPorNome(String nome);
     */

    List<Cliente> findByNomeContainingIgnoreCase(String nome);

}
