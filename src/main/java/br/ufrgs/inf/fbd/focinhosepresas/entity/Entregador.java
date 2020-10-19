package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;

@Entity
@Table(name = "entregador")
public class Entregador {
    @Id
    @Column(name = "cnh")
    private Long cnh;

    @Column(name = "modelo", length = 20, nullable = false)
    private String modelo;

    @Column(name = "placa", length = 7, nullable = false)
    private String placa;

    @OneToOne
    @JoinColumn(name = "cpf_funcionario", nullable = false)
    private Funcionario funcionario;

    public Long getCnh() {
        return cnh;
    }

    public void setCnh(Long cnh) {
        this.cnh = cnh;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
