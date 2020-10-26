package br.ufrgs.inf.fbd.focinhosepresas.query_model;

import java.time.LocalTime;

public interface AppointmentsByDate {
    LocalTime getHora();
    String getNomePet();
    Long getCpfCliente();
    String getNomeFuncionario();
    Short getRegistroVeterinario();
    String getExame();
    String getReceita();
}
