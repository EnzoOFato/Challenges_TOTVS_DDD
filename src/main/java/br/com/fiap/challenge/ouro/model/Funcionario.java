package br.com.fiap.challenge.ouro.model;

public class Funcionario extends Usuario{
    private String cargo;
    private String codRegistro;

    public Funcionario() {

    }

    public Funcionario(String nome, String senha, Integer idade, String cargo, String codRegistro) {
        super(nome, senha, idade);
        this.cargo = cargo;
        this.codRegistro = codRegistro;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCodRegistro() {
        return codRegistro;
    }

    public void setCodRegistro(String codRegistro) {
        this.codRegistro = codRegistro;
    }
}
