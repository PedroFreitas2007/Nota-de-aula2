import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CorridaUber corrida = new CorridaUber();

        System.out.print("Digite a distância percorrida (em km): ");
        corrida.distancia = scanner.nextDouble();

        System.out.print("Digite o tempo de espera (em minutos): ");
        corrida.tempoEspera = scanner.nextInt();

        System.out.print("Digite a tarifa base (R$): ");
        corrida.tarifaBase = scanner.nextDouble();

        System.out.print("Digite o fator de demanda: ");
        corrida.fatorDemanda = scanner.nextDouble();

        corrida.exibirDetalhesCorrida();

        scanner.close();
    }
}
