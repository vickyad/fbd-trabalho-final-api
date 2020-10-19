package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;

    @Column(name = "email", length = 80, unique = true, nullable = false)
    private String email;

    @Column(name = "funcao", length = 80, nullable = false)
    private String funcao;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
