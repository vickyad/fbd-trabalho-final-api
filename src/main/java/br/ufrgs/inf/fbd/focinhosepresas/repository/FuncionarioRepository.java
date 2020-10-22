package br.ufrgs.inf.fbd.focinhosepresas.repository;

import br.ufrgs.inf.fbd.focinhosepresas.entity.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    @Query("SELECT f FROM Funcionario f " +
            "JOIN CargaHoraria ch ON ch.funcionario = f " +
            "WHERE ch.horarioTrabalho.diaSemana = :dow " +
                "AND ch.horarioTrabalho.horaInicio < :initHour " +
                "AND ch.horarioTrabalho.horaFim > :endHour " +
                "AND NOT EXISTS (" +
                    "SELECT sa.funcionario.cpf FROM SlotAgenda sa " +
                        "WHERE sa.hora > :preHour AND sa.hora < :initHour AND sa.data = :date AND sa.funcionario.cpf = f.cpf)")
    List<Funcionario> getAvailableStaff(@Param("date") LocalDate date, @Param("dow") String dayOfWeek, @Param("initHour") LocalTime initHour, @Param("endHour") LocalTime endHour, @Param("preHour") LocalTime preHour);
}
