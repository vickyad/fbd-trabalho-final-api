package br.ufrgs.inf.fbd.focinhosepresas.model;

import br.ufrgs.inf.fbd.focinhosepresas.view.PetCliente;

public class PetInfo {
    private String nomePet;

    private String nomeEspecie;

    private String raca;

    private String restricoes;

    private String nomeCliente;

    private String telefone;

    private String email;

    public PetInfo(PetCliente petCliente) {
        this.nomePet = petCliente.getNomePet();
        this.nomeCliente = petCliente.getNomeCliente();
        this.nomeEspecie = petCliente.getNomeEspecie();
        this.raca = petCliente.getRaca();
        this.restricoes = petCliente.getRestricoes();
        this.nomeCliente = petCliente.getNomeCliente();
        this.telefone = petCliente.getTelefone();
        this.email = petCliente.getEmail();
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(String restricoes) {
        this.restricoes = restricoes;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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
}
