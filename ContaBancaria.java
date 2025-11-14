public class ContaBancaria {

    // Atributos privados (encapsulados)

    private String numeroConta;
    private String titular;
    private double saldo;

    // Construtor

    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        setNumeroConta(numeroConta);
        setTitular(titular);
        setSaldo(saldoInicial);
    }

    // Getters e Setters

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        if (numeroConta == null || numeroConta.isBlank()) {
            throw new IllegalArgumentException("Número da conta não pode ser vazio.");
        }
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("O titular não pode ser vazio.");
        }
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Setter privado para impedir alteração direta
    private void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo não pode ser negativo.");
        }
        this.saldo = saldo;
    }

    // Métodos de negócio (corretos no encapsulamento)

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Depósito deve ser maior que zero.");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O saque deve ser maior que zero.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }
        saldo -= valor;
    }

    // Método extra: exibir dados
 
    public void exibirInformacoes() {
        System.out.println("Conta: " + numeroConta);
        System.out.println("Titular: " + titular);
        System.out.println(String.format("Saldo: R$ %.2f", saldo));
        System.out.println("-----------------------------");
    }
}
