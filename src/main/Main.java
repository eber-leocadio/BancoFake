package main;

import client.Cliente;
import conta.Conta;
import utils.Utils;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        menu();

    }


    public static void menu(){
        int opc;

        do {
            clearConsole();

            System.out.println("====== MENU ======");
            System.out.println("==================");
            System.out.println("[1] Saque");
            System.out.println("[2] Deposito");
            System.out.println("[3] Transferencia");
            System.out.println("[4] Extrato");
            System.out.println("[5] Criar nova conta");
            System.out.println("[6] Listar Contas");
            System.out.println("[0] SAIR");

            do {
                opc = Integer.parseInt(JOptionPane.showInputDialog("Digite qual operacao deseja fazer."));
                if (opc < 0 || opc > 6)
                    System.out.println("Opcao Invalida, escolha uma opcao valida!");
            }while(opc < 0 || opc > 6);


            switch (opc){

                case 1: {

                    sacar();

                    break;
                }

                case 2: {

                    depositar();

                    break;
                }

                case 3: {

                    transferir();

                    break;
                }

                case 4: {

                    extrato();

                    break;
                }

                case 5: {

                    criarConta();

                }

                case 6: {

                    listarContas();

                    break;
                }
            }

        }while(opc != 0);

        System.out.println("Finalizando Operacoes");

    }


    public static void clearConsole(){
        for(int i=0; i<100; i++){
            System.out.println("\n");
        }
    }

    public static void criarConta(){
        System.out.println("Criando Conta");

        String nome = String.format(JOptionPane.showInputDialog("Insira seu Nome"));
        String cpf = String.format(JOptionPane.showInputDialog("CPF:"));

        Cliente cliente = new Cliente(nome, cpf);

        double depositoInicial = Double.parseDouble(JOptionPane.showInputDialog("Deposito Inicial: "));

        Conta conta = new Conta(cliente, depositoInicial);

        contasBancarias.add(conta);

        JOptionPane.showMessageDialog(null,"Conta criada com sucesso!");
    }

    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if(contasBancarias.size() > 0){
            for(Conta contaA : contasBancarias){
                if(contaA.getNumeroConta() == numeroConta){
                    conta = contaA;
                }
            }
        }
        return conta;
    }

    public static void depositar(){
        System.out.println("----- Deposito ----");
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da Conta"));

        Conta conta = encontrarConta(numeroConta);

        if(conta != null){
            double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor Deposito:"));
            conta.depositar(valorDeposito);
            JOptionPane.showMessageDialog(null,("Deposito realizado com sucesso! \n Valor: " + Utils.doubleToString(valorDeposito)));
//            System.out.println("Deposito Realizado com Sucesso! Valor: " + ));

        }else {
            JOptionPane.showMessageDialog(null,"Conta nao encontrada");
//            System.out.println("---- Conta nao encontrada ----");

        }
    }

    public static void sacar(){
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));

        Conta conta = encontrarConta(numeroConta);

        if(conta != null){
            Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Valor do Saque:"));

            conta.sacar(valorSaque);
            JOptionPane.showMessageDialog(null,("Saque Realizado com Suecesso!\n Valor: " + Utils.doubleToString(valorSaque)));

//            System.out.println("Saque Realizado com Sucesso! Valor: " + Utils.doubleToString(valorSaque));

        }else{
            JOptionPane.showMessageDialog(null, "Conta nao encotrada");
//            System.out.println("----- Conta nao Encontrada -----");
        }
    }

    public static void transferir(){
        int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Numero da sua conta: "));

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null){
            int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Numero da Conta Destino:"));

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null){
                Double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Valor a Transferir: "));

                contaRemetente.transferencia(contaDestinatario, valorTransferencia);
            }else{
                JOptionPane.showMessageDialog(null,("---- A conta para deposito nao foi encontrada ----"));

//                System.out.println("---- A conta para deposito nao foi encontrada ----");
            }

        }else{
            JOptionPane.showMessageDialog(null,("---- A conta para transferencia nao foi encontrada ----"));
//            System.out.println("---- Conta para a transferencia nao encontrada ----");
        }
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0){
            for(Conta conta : contasBancarias){
                JOptionPane.showMessageDialog(null,(conta));
//                System.out.println(conta);
            }
        }else {
            JOptionPane.showMessageDialog(null,("---- Nao ha contas cadastradas ----"));

//            System.out.println("----- Nao ha contas cadastradas -----");
        }
    }

    public static void extrato(){
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta:"));

        Conta conta = encontrarConta(numeroConta);
        conta.extrato(conta);
    }

}
