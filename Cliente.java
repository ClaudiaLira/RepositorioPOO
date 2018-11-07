package Projeto;

public class Cliente {

    // Properties
    private String nome;
    private String numero;
    private String cpf;
    private String email;
    private double saldo;

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Constructor

    public Cliente(String nome, String numero, String cpf, String email, double saldo) {
        this.nome = nome;
        this.numero = numero;
        this.cpf = cpf;
        this.email = email;
        this.saldo = saldo;
    }

    public String toString(){
        String result = String.format("Número: %s, Nome: %s, CPF: %s, email: %s, saldo: R$ %.2f", numero, nome, cpf, email, saldo);
        return result;
    }
}
