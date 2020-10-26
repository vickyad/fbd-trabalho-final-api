package br.ufrgs.inf.fbd.focinhosepresas.repository;

import br.ufrgs.inf.fbd.focinhosepresas.entity.SlotAgenda;
import br.ufrgs.inf.fbd.focinhosepresas.query_model.TreatmentsByDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SlotAgendaRepository extends CrudRepository<SlotAgenda, Long>  {
    @Query("SELECT sa.hora as hora, sa.tratamento.nome as nomeTratamento, sa.pet.nome as nomePet, sa.pet.cliente.cpf as cpfCliente, " +
            "sa.funcionario.nome as nomeFuncationario, sa.funcionario.cpf as cpfFuncationario FROM SlotAgenda sa " +
            "WHERE sa.data = :date")
    List<TreatmentsByDate> getTreatmentsByDate(@Param("date") LocalDate date);
}
