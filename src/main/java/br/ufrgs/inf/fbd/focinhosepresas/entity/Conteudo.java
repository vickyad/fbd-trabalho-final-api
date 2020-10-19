package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "conteudo")
public class Conteudo {
    private static final String SEQUENCE_NAME = "conteudo_id_cont_seq";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Column(name = "id_cont")
    private Long id;

    @Column(name = "quant", nullable = false)
    private Integer quantidade;

    @OneToOne
    @JoinColumn(name = "nro_pedido", nullable = false)
    private Pedido pedido;

    @OneToOne
    @JoinColumn(name = "cod_produto", nullable = false)
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
