package br.ufrgs.inf.fbd.focinhosepresas.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "total_gasto")
public class TotalGasto {
    @Id
    @Column(name = "cpf_cliente")
    private Long cpf;

    @Column(name="valor", nullable = false)
    private Float valor;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
