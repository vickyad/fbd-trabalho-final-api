package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "pedido")
public class Pedido {
    private static final String SEQUENCE_NAME = "pedido_nro_seq";
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Column(name="nro")
    private Long nro;

    @Column(name = "data_ped", nullable = false)
    private Date data;

    @Column(name="preco_total", nullable = false)
    private Float preco_total;

    @OneToOne
    @JoinColumn(name = "cpf_cliente", nullable = false)
    private Cliente cliente;

    public Long getNro() {
        return nro;
    }

    public void setNro(Long nro) {
        this.nro = nro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(Float preco_total) {
        this.preco_total = preco_total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
