package br.com.vendas.domain.service;

import br.com.vendas.domain.filter.VendaFilter;
import br.com.vendas.domain.model.Venda;
import br.com.vendas.domain.pagination.Pagination;

public interface VendaQueryService {

    Pagination<Venda> listar(VendaFilter filter);
}
