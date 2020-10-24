package br.ufrgs.inf.fbd.focinhosepresas.model;

import java.time.LocalDate;

public interface OrderInfo {
    Long getNroPedido();
    LocalDate getDataPedido();
    Long getCpfCliente();
    Integer getQuantidade();
    String getNomeProduto();
    String getNomeCategoria();
    String getPreco();
    String getPrecoTotal();
    String getFrete();
    String getStatus();
}
