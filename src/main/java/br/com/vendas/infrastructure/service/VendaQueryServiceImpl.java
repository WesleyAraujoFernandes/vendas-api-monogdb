package br.com.vendas.infrastructure.service;

import br.com.vendas.domain.filter.VendaFilter;
import br.com.vendas.domain.model.Venda;
import br.com.vendas.domain.pagination.Pagination;
import br.com.vendas.domain.service.VendaQueryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class VendaQueryServiceImpl implements VendaQueryService {

    private final MongoTemplate mongoTemplate;

    public VendaQueryServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Pagination<Venda> listar(VendaFilter filter) {

        Query query = new Query();

        if (StringUtils.hasText(filter.getClienteId())) {
            query.addCriteria(Criteria.where("clienteId").is(filter.getClienteId()));
        }

        if (filter.getDataInicio() != null && filter.getDataFim() != null) {
            query.addCriteria(Criteria.where("data")
                    .gte(filter.getDataInicio().atStartOfDay())
                    .lte(filter.getDataFim().atTime(23, 59, 59)));
        }

        Pageable pageable = PageRequest.of(
                filter.getPagina(), filter.getPorPagina(),
                Sort.by(Sort.Direction.fromString(filter.getOrdem()), filter.getOrdenarPor()));

        List<Venda> vendas = mongoTemplate.find(query.with(pageable), Venda.class);

        return new Pagination<>(
                pageable.getPageNumber() + 1,
                pageable.getPageSize(),
                mongoTemplate.count(query, Venda.class),
                vendas
        );
    }
}
