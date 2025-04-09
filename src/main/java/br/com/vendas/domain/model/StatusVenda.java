package br.com.vendas.domain.model;

public enum StatusVenda {

    ABERTA(1),
    FECHADA(2);

    private Integer codigo;

    StatusVenda(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusVenda fromCodigo(int codigo) {
        for (StatusVenda status : StatusVenda.values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}
