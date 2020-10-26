package br.ufrgs.inf.fbd.focinhosepresas.query_model;

import java.time.LocalDate;
import java.time.LocalTime;

public interface PetRecords {
    String getExame();
    String getReceita();
    LocalDate getData();
    LocalTime getHora();
    String getFuncionarioNome();
    Short getRegistro();
}
