package br.com.vendas.domain.model;

public enum StatusVenda {

    ABERTA(1),
    FINALIZADA(2),
    CANCELADA(3);

    private Integer codigo;

    StatusVenda(Integer codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusVenda fromCodigo(Integer codigo) {
        for (StatusVenda status : StatusVenda.values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
