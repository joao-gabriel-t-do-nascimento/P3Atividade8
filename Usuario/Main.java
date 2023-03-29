package P3Atividade8.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        Conta conta = new Conta(null, null, null);
        char resp = 's';

        while (resp == 's') {
            System.out.println("Digite 0 para criar conta");
            System.out.println("Digite 1 para depositar dinheiro");
            System.out.println("Digite 2 para sacar dinheiro");
            System.out.println("Digite 3 para ver seu saldo");
            int menu = in.nextInt();

            switch (menu) {
                case 0:
                    if (conta.getNumero() != 0) {
                        System.out.println("Você já tem uma conta");
                    } else {
                        System.out.println("Digite seu nome completo");
                        String nome = inStr.nextLine();
                        System.out.println("Digite sua senha");
                        String senha = inStr.nextLine();
                        System.out.println("Confirme sua senha");
                        String verificar = inStr.nextLine();
                        while (!senha.equals(verificar)) {
                            System.out.println("Senhas não batem, digite novamente");
                            verificar = in.nextLine();
                        }
                        System.out.println("Digite seu cpf");
                        String cpf = inStr.nextLine();
                        conta = new Conta(nome, senha, cpf);
                        System.out.println("O número da sua conta é: " + conta.getNumero());
                    }
                    break;
                case 1:
                    if (conta.getNumero() == 0) {
                        System.out.println("Crie uma conta primeito!");
                    } else {
                        System.out.println("Digite o número da sua conta");
                        int verificarContaDeposito = in.nextInt();
                        while (conta.getNumero() != verificarContaDeposito) {
                            System.out.println("Número da conta errado, digite novamente");
                            verificarContaDeposito = in.nextInt();
                        }
                        System.out.print("Valor a ser depositado: ");
                        Double deposito = in.nextDouble();
                        if (deposito < 0) {
                            break;
                        }
                        conta.depositar(deposito);
                    }
                    break;
                case 2:
                    if (conta.getNumero() == 0) {
                        System.out.println("Crie uma conta primeiro!");
                    } else {
                        System.out.println("Digite o número da sua conta");
                        int verificarContaSaldo = in.nextInt();
                        while (conta.getNumero() != verificarContaSaldo) {
                            System.out.println("Número da conta errado, digite novamente");
                            verificarContaSaldo = in.nextInt();
                        }
                        System.out.println("Seu saldo: " + conta.getSaldo());
                        System.out.println("Digite o calor a ser sacado");
                        double saque = in.nextDouble();
                        if (saque < 0) {
                            break;
                        }
                        conta.sacar(saque);
                    }
                    break;
                case 3:
                    if (conta.getNumero() == 0) {
                        System.out.println("Crie uma conta primeiro!");
                    } else {
                        System.out.println("Digite o número da sua conta");
                        int verificarContaSaldo = in.nextInt();
                        while (conta.getNumero() != verificarContaSaldo) {
                            System.out.println("Número da conta errado, digite novamente");
                            verificarContaSaldo = in.nextInt();
                        }
                        System.out.println(conta.getSaldo());
                    }
                    break;
                default:
                    System.out.println("Ação inválida");
                    break;
            }
            System.out.println("Deseja realizar outra operação? s/n");
            resp = in.next().charAt(0);
            resp = Character.toLowerCase(resp);
            while (resp != 's' && resp != 'n') {
                System.out.println("Opção inválida digite novamente");
                resp = in.next().charAt(0);
                resp = Character.toLowerCase(resp);
            }
        }
        in.close();
        inStr.close();
    }
}
