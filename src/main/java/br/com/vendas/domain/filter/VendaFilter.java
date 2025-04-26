package br.com.vendas.domain.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class VendaFilter {

    private String clienteId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFim;
    private Integer pagina = 1;
    private Integer porPagina = 10;
    private String ordem = "desc";
    private String ordenarPor = "data";

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getOrdenarPor() {
        return ordenarPor;
    }

    public void setOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public Integer getPorPagina() {
        return porPagina;
    }

    public void setPorPagina(Integer porPagina) {
        this.porPagina = porPagina;
    }

    public Integer getPagina() {
        return this.pagina > 0 ? this.pagina - 1 : 0;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
}
