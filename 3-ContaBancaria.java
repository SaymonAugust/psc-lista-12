public class ContaBancaria {

    // Atributos privados (encapsulados)
    private String numeroConta;
    private String titular;
    private double saldo;

    // Construtor
    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        setNumeroConta(numeroConta);
        setTitular(titular);
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            System.out.println("Saldo inicial inválido. Definido como 0.");
            this.saldo = 0;
        }
    }
  
    // GETTERS
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // SETTERS (somente os permitidos)
    public void setNumeroConta(String numeroConta) {
        if (numeroConta == null || numeroConta.isBlank()) {
            System.out.println("Número da conta inválido!");
            return;
        }
        this.numeroConta = numeroConta;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            System.out.println("Nome do titular inválido!");
            return;
        }
        this.titular = titular;
    }

    // MÉTODOS DE TRANSAÇÃO

    // DEPÓSITO
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("ERRO: O valor do depósito deve ser maior que zero.");
            return;
        }

        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado com sucesso!\n", valor);
    }

    // SAQUE
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("ERRO: O valor do saque deve ser maior que zero.");
            return;
        }

        if (valor > saldo) {
            System.out.println("ERRO: Saldo insuficiente para realizar o saque.");
            return;
        }

        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", valor);
    }

    // Exibir informações
    public void exibirInformacoes() {
        System.out.println("\n=== Dados da Conta ===");
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);
        System.out.println("=========================");
    }
}
