public class ContaBancaria {
    String titular;
    double saldo;
    double selic;
    boolean tipoContaCorrente;
    final double LIMITE_CHEQUE_ESPECIAL = 1000.00;

    public void selecionarConta(boolean isContaCorrente) {
        tipoContaCorrente = isContaCorrente;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso!");
        } else if (tipoContaCorrente && valor <= saldo + LIMITE_CHEQUE_ESPECIAL) {
            double chequeEspecialUsado = valor - saldo;
            saldo = 0;
            System.out.println("Saque de " + valor + " realizado. Cheque especial usado: " + chequeEspecialUsado);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void calcularRendimento(double taxaSelic) {
        selic = taxaSelic;
        if (!tipoContaCorrente) {
            double rendimento;
            if (selic > 8.5) {
                rendimento = 0.005 * saldo;
            } else {
                rendimento = 0.007 * selic * saldo;
            }
            saldo += rendimento;
            System.out.println("Rendimento calculado: " + rendimento);
        } else {
            System.out.println("Operação não disponível para conta corrente.");
        }
    }

    public void exibirDados() {
        String tipoConta = tipoContaCorrente ? "Conta Corrente" : "Conta Poupança";
        System.out.println("Titular: " + titular);
        System.out.println("Tipo de Conta: " + tipoConta);
        System.out.println("Saldo: " + saldo);
        if (tipoContaCorrente) {
            System.out.println("Limite do Cheque Especial: " + LIMITE_CHEQUE_ESPECIAL);
        }
    }
}
