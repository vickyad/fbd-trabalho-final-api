package br.ufrgs.inf.fbd.focinhosepresas.model;

import br.ufrgs.inf.fbd.focinhosepresas.entity.Funcionario;

public class AvailableStaff {
    private String nome;
    private Long cpf;

    public AvailableStaff(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
