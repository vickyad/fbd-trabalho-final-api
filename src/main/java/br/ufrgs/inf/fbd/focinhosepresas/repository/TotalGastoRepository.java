package br.ufrgs.inf.fbd.focinhosepresas.repository;

import br.ufrgs.inf.fbd.focinhosepresas.view.TotalGasto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TotalGastoRepository extends CrudRepository<TotalGasto, Long> {
    @Query("SELECT tg FROM TotalGasto tg WHERE tg.valor > (SELECT AVG(tg2.valor) FROM TotalGasto tg2)")
    List<TotalGasto> getClienteWithSpendingAboveAverage();
}