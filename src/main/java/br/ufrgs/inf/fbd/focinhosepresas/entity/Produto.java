package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="produto")
public class Produto {
    private static final String SEQUENCE_NAME = "produto_cod_seq";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Column(name="cod")
    private Long cod;

    @Column(name="nome", length = 150, nullable = false)
    private String nome;

    @Column(name="preco", nullable = false)
    private Float preco;

    @Column(name="estoque", nullable = false)
    private Integer estoque;

    @OneToOne
    @JoinColumn(name = "categoria", nullable = false)
    private Categoria categoria;

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

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

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
