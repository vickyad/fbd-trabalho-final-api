package br.ufrgs.inf.fbd.focinhosepresas.query_model;

import java.time.LocalTime;

public interface TreatmentsByDate {
    LocalTime getHora();
    String getNomeTratamento();
    String getNomePet();
    Long getCpfCliente();
    String getNomeFuncationario();
    Long getCpfFuncationario();
}
