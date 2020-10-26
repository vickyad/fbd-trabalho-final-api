package br.ufrgs.inf.fbd.focinhosepresas.repository;

import java.util.List;

import br.ufrgs.inf.fbd.focinhosepresas.query_model.OrderInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufrgs.inf.fbd.focinhosepresas.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    @Query(value = "SELECT nro_pedido as nroPedido, data_ped as dataPedido, cpf_cliente as cpfCliente, " +
            "quant as quantidade, Produto.nome as nomeProduto, Categoria.nome as nomeCategoria, " +
            "CAST(preco AS NUMERIC) as preco, CAST(preco_total AS NUMERIC) as precoTotal, " +
            "CAST(frete AS NUMERIC) as frete, status as status FROM Pedido " +
            "JOIN Conteudo ON Pedido.nro = Conteudo.nro_pedido " +
            "JOIN Produto ON Conteudo.cod_produto = Produto.cod " +
            "JOIN Categoria ON Produto.categoria = Categoria.nome " +
            "LEFT JOIN Envio ON Pedido.nro = Envio.cod_pedido " +
            "WHERE Pedido.nro = :nroPed", nativeQuery = true)
    List<OrderInfo> getOrderInfo(@Param("nroPed") Long nroPed);

    @Query("SELECT p FROM Envio e " +
            "JOIN Conteudo con ON p = con.pedido " +
            "JOIN Produto prod ON con.produto = prod " +
            "JOIN Categoria cat ON prod.categoria = cat " +
            "JOIN Pedido p ON p = e.pedido " +
            "WHERE p.nro = :nroPed")
    List<Pedido> teste(@Param("nroPed") Integer nroPed);
}

/*
SELECT cod_pedido, pedido.cpf_cliente, endereco.rua, endereco.nro, endereco.compl, endereco.cidade, funcionario.nome, cpf FROM envio
JOIN entregador ON entregador.cnh = envio.cnh
JOIN funcionario ON entregador.cpf_funcionario = funcionario.cpf
JOIN endereco ON envio.id_endereco = endereco.id_end
JOIN pedido ON envio.cod_pedido = pedido.nro
WHERE NOT envio.status='entregue';
 */