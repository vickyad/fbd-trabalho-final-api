package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "horario_trabalho", uniqueConstraints=
@UniqueConstraint(columnNames={"dia_semana", "hora_inicio"}))
public class HorarioTrabalho {

    @Id
    @Column(name = "id_horario")
    private Long id;

    @Column(name = "dia_semana", length = 3, nullable = false)
    private String diaSemana;

    @Column(name = "hora_inicio", nullable = false)
    private Time horaInicio;

    @Column(name = "hora_fim", nullable = false)
    private Time horaFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }
}
