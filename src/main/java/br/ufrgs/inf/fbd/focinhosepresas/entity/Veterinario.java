package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;

@Entity
@Table(name="veterinario")
public class Veterinario {
    @Id
    @Column(name="registro")
    private Short registro;

    @OneToOne
    @JoinColumn(name = "cpf_funcionario", nullable = false)
    private Funcionario funcionario;

    public Short getRegistro() {
        return registro;
    }

    public void setRegistro(Short registro) {
        this.registro = registro;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
