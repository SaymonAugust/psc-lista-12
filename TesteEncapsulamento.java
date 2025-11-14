public class TesteEncapsulamento {
    public static void main(String[] args) {

        // 4.1 Criar nova instância de ContaBancaria
        ContaBancaria conta = new ContaBancaria("0000-0", "Desconhecido", 0);

        System.out.println(">>> TESTANDO ENCAPSULAMENTO\n");

        // 4.2 Tentativa de acessar atributos diretamente
        // (ERRO DE COMPILAÇÃO caso descomente)
        
        // conta.saldo = 500;          // ERRO: saldo é private
        // conta.numeroConta = "123";  // ERRO: numeroConta é private
        // conta.titular = "Saymon";   // ERRO: titular é private
        
        System.out.println("Erro de encapsulamento demonstrado! (Acesso direto é proibido)");

        // 4.3 Inicialização correta usando SETTERS
        System.out.println("\n>>> Inicializando dados corretamente (via Setters)...");
        conta.setNumeroConta("12345-9");
        conta.setTitular("Saymon Augusto");

        // 4.4 Testando métodos de transação
        System.out.println("\n>>> Testando depósitos e saques:\n");

        // Depósito válido
        conta.depositar(300);

        // Depósito inválido
        conta.depositar(-50);

        // Saque válido
        conta.sacar(100);

        // Saque inválido (saldo insuficiente)
        conta.sacar(5000);

        // Saque inválido (valor negativo)
        conta.sacar(-10);

        // Exibir saldo final
        System.out.println("\n>>> Saldo final (via getSaldo()): R$ " + conta.getSaldo());
    }
}
