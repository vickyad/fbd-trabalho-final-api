package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="slot_agenda")
public class SlotAgenda {
    private static final String SEQUENCE_NAME = "slot_agenda_id_agenda_seq";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Column(name="id_agenda")
    private Long id;

    @Column(name = "data_agenda", nullable = false)
    private Date data;

    @Column(name = "hora", nullable = false)
    private Time hora;
    
    @OneToOne
    @JoinColumn(name = "cpf_funcionario", nullable = false)
    private Funcionario funcionario;

    @OneToOne
    @JoinColumn(name = "id_pet", nullable = false)
    private Pet pet;

    @OneToOne
    @JoinColumn(name = "tratamento", nullable = false)
    private Tratamento tratamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }
}
