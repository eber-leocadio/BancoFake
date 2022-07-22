package client;

import java.util.Date;

public class Cliente {

    private static int counter = 1;

    private int numeroCliente;
    private String nomeCliente;
    private String cpf;
    private Date dataCriacaoConta;

    public Cliente() { }

    public Cliente(String nome, String cpf){
        this.numeroCliente = Cliente.counter;
        this.nomeCliente = nome;
        this.cpf = cpf;
        this.dataCriacaoConta = new Date();
        Cliente.counter += 1;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCriacaoConta() {
        return dataCriacaoConta;
    }

    @Override
    public String toString() {
        return  "\n Numero do Cliente: " + this.getNumeroCliente() +
                "\n Nome: " + this.getNomeCliente() +
                "\n CPF: " + this.getCpf() +
                "\n Conta Criada: " + this.getDataCriacaoConta();
    }
}
