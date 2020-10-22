package br.ufrgs.inf.fbd.focinhosepresas.view;

import javax.persistence.*;

@Entity
@Table(name = "pet_cliente")
public class PetCliente {
    @Id
    @Column(name = "cpf")
    Long cpf;

    @Column(name="nome_p", length = 60, nullable = false)
    String nomePet;

    @Column(name = "nome_e", length = 50, nullable = false)
    String nomeEspecie;

    @Column(name = "nome_c", length = 60, nullable = false)
    String nomeCliente;

    @Column(name="restricoes")
    String restricoes;

    @Column(name = "telefone", length = 11, nullable = false)
    String telefone;

    @Column(name = "email", length = 80, unique = true, nullable = false)
    String email;

    @Column(name = "raca", length = 50)
    String raca;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(String restricoes) {
        this.restricoes = restricoes;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
