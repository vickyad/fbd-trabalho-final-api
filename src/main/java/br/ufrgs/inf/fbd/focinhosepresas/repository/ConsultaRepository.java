package br.ufrgs.inf.fbd.focinhosepresas.repository;

import br.ufrgs.inf.fbd.focinhosepresas.entity.Consulta;
import br.ufrgs.inf.fbd.focinhosepresas.query_model.AppointmentsByDate;
import br.ufrgs.inf.fbd.focinhosepresas.query_model.PetRecords;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Long> {
    @Query("SELECT c.exame as exame, c.receita as receita, c.data as data, c.hora as hora, c.veterinario.funcionario.nome as funcionarioNome, c.veterinario.registro as registro " +
            "FROM Consulta c " +
            "WHERE c.pet.nome = :nomePet AND c.pet.cliente.cpf = :cpf")
    List<PetRecords> getPetRecords(@Param("nomePet") String nomePet, @Param("cpf") Long cpf);

    @Query("SELECT c.hora as hora, c.pet.nome as nomePet, c.pet.cliente.cpf as cpfCliente, c.veterinario.funcionario.nome as nomeFuncionario, " +
            "c.veterinario.registro as registroVeterinario, c.exame as exame, c.receita as receita FROM Consulta c")
    List<AppointmentsByDate> getAppointmentsByDate(@Param("date") LocalDate date);

}
