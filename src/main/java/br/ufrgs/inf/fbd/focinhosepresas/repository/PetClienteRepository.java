package br.ufrgs.inf.fbd.focinhosepresas.repository;

import br.ufrgs.inf.fbd.focinhosepresas.view.PetCliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PetClienteRepository extends CrudRepository<PetCliente, Long> {
    @Query("SELECT pc FROM PetCliente pc WHERE pc.nomePet = :nomePet AND pc.cpf = :cpf")
    Optional<PetCliente> getPetInfo(@Param("nomePet") String nomePet, @Param("cpf") Long cpf);

    @Query("SELECT DISTINCT pc.nomeCliente FROM PetCliente pc WHERE pc.nomeEspecie = :nomeEspecie")
    List<String> getClientByPet(@Param("nomeEspecie") String nomeEspecie);
}