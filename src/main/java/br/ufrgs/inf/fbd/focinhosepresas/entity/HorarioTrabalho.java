package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;
import java.time.LocalTime;

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
    private LocalTime horaInicio;

    @Column(name = "hora_fim", nullable = false)
    private LocalTime horaFim;

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

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
}
