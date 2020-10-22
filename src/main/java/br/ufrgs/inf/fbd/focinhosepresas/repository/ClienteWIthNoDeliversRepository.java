package br.ufrgs.inf.fbd.focinhosepresas.repository;

import java.util.List;

import br.ufrgs.inf.fbd.focinhosepresas.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteWIthNoDeliversRepository extends CrudRepository<Cliente, Long> {
    @Query(value = "SELECT c.* FROM Cliente c EXCEPT " +
            "SELECT c.* FROM Cliente c " +
            "JOIN Pedido p ON p.cpf_cliente = c.cpf " +
            "JOIN Envio e ON e.cod_pedido = p.nro", nativeQuery = true)
    List<Cliente> getClientsWithNoDelivers();
}
