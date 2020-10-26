package br.ufrgs.inf.fbd.focinhosepresas.repository;

import br.ufrgs.inf.fbd.focinhosepresas.entity.Envio;
import br.ufrgs.inf.fbd.focinhosepresas.query_model.DeliverNotDelivered;
import br.ufrgs.inf.fbd.focinhosepresas.query_model.DelivermanDelivers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvioRepository extends CrudRepository<Envio, Long>  {
    @Query("SELECT e.pedido.nro as codPedido, e.pedido.cliente.cpf as cpfCliente, e.endereco.rua as rua, e.endereco.nro as nro, e.endereco.complemento as complemento, e.endereco.cidade as cidade, e.entregador.funcionario.nome as nomeEntregador, e.entregador.funcionario.cpf as cpfFuncionario " +
            "FROM Envio e " +
            "WHERE e.status = 'recebido'")
    List<DeliverNotDelivered> getDeliversNotDelivered();

    @Query("SELECT e.pedido.nro as codPedido, e.status as status, e.endereco.rua as rua, e.endereco.nro as nro, e.endereco.complemento as complemento, e.endereco.cidade as cidade " +
            "FROM Envio e " +
            "WHERE e.status = 'recebido' AND e.entregador.funcionario.cpf = :cpfFuncionario")
    List<DelivermanDelivers> getDelivermanDelivers(Long cpfFuncionario);
}