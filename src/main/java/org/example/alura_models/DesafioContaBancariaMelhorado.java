package org.example.alura_models;

import java.util.Scanner;

public class DesafioContaBancariaMelhorado {
    public static void main(String[] args) {

        String nome = "Clark Kent";
        String tipoConta = "Corrente";
        double saldo = 1599.99;
        int opcao = 0;

        System.out.println("***********************");
        System.out.println("\nNome do cliente: " + nome);
        System.out.println("Tipo conta: " + tipoConta);
        System.out.println("Saldo atual: " + String.format("%.2f", saldo));
        System.out.println("\n***********************");

        Scanner leitura = new Scanner(System.in);

        final int CONSULTAR_SALDO = 1;
        final int TRANSFERIR_VALOR = 2;
        final int RECEBER_VALOR = 3;
        final int SAIR = 4;

        String menu = """
                ** Digite sua opção **
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor 
                4 - Sair
                """;

        while (opcao != SAIR) {
            System.out.println(menu);

            if (leitura.hasNextInt()) {
                opcao = leitura.nextInt();
            } else {
                System.out.println("Opção inválida! Digite um número.");
                leitura.next(); // Limpa o buffer
                continue;
            }

            switch (opcao) {
                case CONSULTAR_SALDO:
                    System.out.println("O saldo atualizado é " + String.format("%.2f", saldo));
                    break;

                case TRANSFERIR_VALOR:
                    System.out.println("Qual o valor que deseja transferir?");
                    double valorTransferir = leitura.nextDouble();
                    if (valorTransferir <= 0) {
                        System.out.println("Valor inválido. O valor deve ser maior que zero.");
                    } else if (valorTransferir > saldo) {
                        System.out.println("Não há saldo para realizar a transferência.");
                    } else {
                        saldo -= valorTransferir;
                        System.out.println("Novo saldo: " + String.format("%.2f", saldo));
                    }
                    break;

                case RECEBER_VALOR:
                    System.out.println("Valor recebido: ");
                    double valorReceber = leitura.nextDouble();
                    if (valorReceber <= 0) {
                        System.out.println("Valor inválido. O valor deve ser maior que zero.");
                    } else {
                        saldo += valorReceber;
                        System.out.println("Novo saldo: " + String.format("%.2f", saldo));
                    }
                    break;

                case SAIR:
                    System.out.println("Saindo... Obrigado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        leitura.close(); // Fecha o Scanner
    }
}
