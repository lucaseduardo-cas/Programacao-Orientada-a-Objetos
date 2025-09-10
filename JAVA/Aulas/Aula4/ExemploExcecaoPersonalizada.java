/*
Exceções personalizadas

Definições:
    - Exceções personalizadas são classes criadas para representar erros
    específicos da aplicação.
    - Devem estender Exception (checked) ou RuntimeException (unchecked).
    - Permitem criar semântica específica para os erros do domínio.
    - Facilitam tratamento diferenciado por tipo de erro.
    - Devem ter construtores adequados (mensagem, causa, etc.).
    - Melhoram legibilidade e manutenibilidade do código de tratamento.

    javac -d Classes ExemploExcecaoPersonalizada.java && java -cp Classes ExemploExcecaoPersonalizada
*/

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

public class ExemploExcecaoPersonalizada {
    public static void main(String[] args) {
        double saldo = 100;
        double saque = 150;

        try {
            if (saque > saldo) {
                throw new SaldoInsuficienteException("Saldo insuficiente para saque de " + saque);
            }
            saldo -= saque;
            System.out.println("Saque realizado. Saldo: " + saldo);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
