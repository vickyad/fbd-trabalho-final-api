package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Time;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "consulta", uniqueConstraints=
@UniqueConstraint(columnNames={"data_cons", "hora", "registro_vet", "id_pet"}))
public class Consulta {
    private static final String SEQUENCE_NAME = "consulta_id_cons_seq";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Column(name = "id_cons")
    private Long id;

    @Column(name = "exame", length = 80, nullable = false)
    private String exame;

    @Column(name = "receita", length = 80, nullable = false)
    private String receita;

    @Column(name = "data_cons", nullable = false)
    private Date data;

    @Column(name = "hora", nullable = false)
    private Time hora;

    @OneToOne
    @JoinColumn(name = "registro_vet", nullable = false)
    private Veterinario veterinario;

    @OneToOne
    @JoinColumn(name = "id_pet", nullable = false)
    private Pet pet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
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

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
