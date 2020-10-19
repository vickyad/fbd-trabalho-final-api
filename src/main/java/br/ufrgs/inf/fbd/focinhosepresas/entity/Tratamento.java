package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;

@Entity
@Table(name="tratamento")
public class Tratamento {
    @Id
    @Column(name="nome")
    private String nome;

    @Column(name="preco", nullable = false)
    private Float preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
}
