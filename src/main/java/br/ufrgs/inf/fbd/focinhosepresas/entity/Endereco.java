package br.ufrgs.inf.fbd.focinhosepresas.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "endereco")
public class Endereco {
    private static final String SEQUENCE_NAME = "consulta_id_cons_seq";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @Column(name = "id_end")
    private Long id;

    @Column(name = "rua", length = 100, nullable = false)
    private String rua;

    @Column(name = "compl", length = 100)
    private String complemento;

    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;

    @Column(name = "nro", nullable = false)
    private Short nro;

    @OneToOne
    @JoinColumn(name = "cpf_cliente", nullable = false)
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "cpf_funcionario", nullable = false)
    private Funcionario funcionario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Short getNro() {
        return nro;
    }

    public void setNro(Short nro) {
        this.nro = nro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
