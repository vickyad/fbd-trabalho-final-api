package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "pet")
public class Pet {
    private static final String SEQUENCE_NAME = "pet_id_pet_seq";
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Column(name="id_pet")
    private Long id;

    @Column(name="nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "data_nasc", nullable = false)
    private LocalDate dataNascimento;

    @Column(name="restricoes")
    private String restricoes;

    @Column(name="cpf_cliente", nullable = false)
    private Long cpf_cliente;

    @OneToOne
    @JoinColumn(name = "id_raca", nullable = false)
    private Especie especie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(String restricoes) {
        this.restricoes = restricoes;
    }

    public Long getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(Long cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
