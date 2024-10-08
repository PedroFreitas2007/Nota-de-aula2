import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();

        System.out.print("Digite o nome do titular: ");
        conta.titular = scanner.nextLine();

        System.out.println("Selecione o tipo de conta: \n1. Conta Corrente\n2. Conta Poupança");
        int tipoConta = scanner.nextInt();
        conta.selecionarConta(tipoConta == 1);

        int opcao;
        do {            System.out.println("\nMenu:");
            if (conta.tipoContaCorrente) {
                System.out.println("1. Depositar\n2. Sacar\n3. Usar Cheque Especial\n4. Exibir Dados\n5. Sair");
            } else {
                System.out.println("1. Depositar\n2. Sacar\n3. Calcular Rendimento\n4. Exibir Dados\n5. Sair");
            }

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 2:
                    System.out.print("Digite o valor do saque: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 3:
                    if (conta.tipoContaCorrente) {
                        System.out.print("Digite o valor do saque utilizando cheque especial: ");
                        double saqueChequeEspecial = scanner.nextDouble();
                        conta.sacar(saqueChequeEspecial);
                    } else {
                        System.out.print("Digite a taxa Selic atual: ");
                        double taxaSelic = scanner.nextDouble();
                        conta.calcularRendimento(taxaSelic);
                    }
                    break;
                case 4:
                    conta.exibirDados();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
}
