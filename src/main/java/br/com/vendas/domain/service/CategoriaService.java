package br.com.vendas.domain.service;

import br.com.vendas.domain.model.Categoria;
import br.com.vendas.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria cadastrar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria buscarPorId(String id) {
        return categoriaRepository.findById(id).orElseThrow();
    }

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
}
