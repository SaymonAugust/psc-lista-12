public class ContaBancaria {

    // Atributos privados (encapsulados)
    private String numeroConta;
    private String titular;
    private double saldo;

    // Construtor
    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        setNumeroConta(numeroConta);  // validação automática
        setTitular(titular);          // validação automática
        this.saldo = saldoInicial >= 0 ? saldoInicial : 0; 
    }

    // GETTERS (Acesso)

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // SETTERS (Modificação)

    public void setNumeroConta(String numeroConta) {
        if (numeroConta == null || numeroConta.isBlank()) {
            throw new IllegalArgumentException("Número da conta não pode ser nulo ou vazio.");
        }
        this.numeroConta = numeroConta;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular não pode ser nulo ou vazio.");
        }
        this.titular = titular;
    }

    // Observação: NÃO existe setter para saldo.
    // O saldo só pode mudar através dos métodos depositar() e sacar().

    // MÉTODOS DE OPERAÇÃO

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }
        saldo -= valor;
    }

    // Exibir dados
    public void exibirInformacoes() {
        System.out.println("\n=== Dados da Conta ===");
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo: R$ %.2f\n", saldo);
        System.out.println("=========================");
    }
}
