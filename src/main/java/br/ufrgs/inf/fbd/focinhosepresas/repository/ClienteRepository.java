package br.ufrgs.inf.fbd.focinhosepresas.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import br.ufrgs.inf.fbd.focinhosepresas.entity.Cliente;
import br.ufrgs.inf.fbd.focinhosepresas.query_model.TotalSpentByClient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    @Query(value = "SELECT c.* FROM Cliente c EXCEPT " +
            "SELECT c.* FROM Cliente c " +
            "JOIN Pedido p ON p.cpf_cliente = c.cpf " +
            "JOIN Envio e ON e.cod_pedido = p.nro", nativeQuery = true)
    List<Cliente> getClientsWithNoDelivers();

    @Query("SELECT COUNT(c) FROM Cliente c " +
            "JOIN Pet p ON p.cliente = c " +
            "JOIN Consulta con ON con.pet = p " + 
            "WHERE c.cpf = :cpf AND con.data >= :date " +
            "GROUP BY c.cpf, p.id")
    Optional<Integer> getPetAppointmentsByClientAndDate(@Param("cpf") Long cpf, @Param("date") LocalDate date);

    @Query(value = "SELECT SUM((COALESCE(CAST(Pedido.preco_total AS NUMERIC), 0) + COALESCE(CAST(Tratamento.preco AS NUMERIC), 0))) AS totalValue, Cliente.cpf AS cpf " +
            " FROM Cliente" +
            " LEFT JOIN Pedido ON Pedido.cpf_cliente = Cliente.cpf" +
            " LEFT JOIN Pet ON Pet.cpf_cliente = Cliente.cpf" +
            " LEFT JOIN Slot_Agenda ON Slot_Agenda.id_pet = Pet.id_pet" +
            " LEFT join Tratamento ON Tratamento.nome = Slot_Agenda.tratamento" +
            " GROUP BY Cliente.cpf", nativeQuery = true)
    List<TotalSpentByClient> getTotalSpentByClients();
}
