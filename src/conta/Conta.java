package conta;

import client.Cliente;
import utils.Utils;

import javax.swing.*;

public class Conta {

    private static int contaCounter = 1;
    private static final int agencia = 11;


    private int numeroConta;
    private Cliente cliente;
    private double saldo = 0.0;

    public Conta(Cliente cliente, double saldo) {
        this.numeroConta = Conta.contaCounter;
        this.cliente = cliente;
        this.saldo = saldo;
        Conta.contaCounter += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private void updateSaldo(){
        this.saldo = this.getSaldo();
    }

    @Override
    public String toString() {
        return "\n Conta do Banco: " + this.getNumeroConta() +
                "\n Cliente: " + this.cliente.getNomeCliente() +
                "\n CPF: " + this.cliente.getCpf() +
                "\n Saldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Seu deposito foi realizado com sucesso!");
        }else{
            System.out.println("Nao foi possivel realizar o deposito!");
        }
    }

    public void sacar(Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        }else{
            System.out.println("Nao foi possivel realizar o saque!");
        }
    }

    public void transferencia(Conta contaParaDeposito, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferencia realizada com sucesso!");
        }else {
            System.out.println("Nao foi possivel realizar a transferencia!");
        }
    }

    public void extrato(Conta conta){

        JOptionPane.showMessageDialog(null, conta);
    }
}
