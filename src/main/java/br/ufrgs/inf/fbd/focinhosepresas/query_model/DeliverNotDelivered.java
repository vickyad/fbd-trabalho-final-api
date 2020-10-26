package br.ufrgs.inf.fbd.focinhosepresas.query_model;

public interface DeliverNotDelivered {
    Long getCodPedido();
    Long getCpfCliente();
    String getRua();
    Short  getNro();
    String getComplemento();
    String getCidade();
    String getNomeEntregador();
    Long getCpfFuncionario();
}
