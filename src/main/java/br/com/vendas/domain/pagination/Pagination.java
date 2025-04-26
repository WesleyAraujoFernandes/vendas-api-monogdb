package br.com.vendas.domain.pagination;

import java.util.List;

public record Pagination<T>(
        Integer pagina,
        Integer porPagina,
        Long total,
        List<T> resultado
) {}
