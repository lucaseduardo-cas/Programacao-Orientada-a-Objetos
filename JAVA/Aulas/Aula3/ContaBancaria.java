/* 
ENCAPSULAMENTO

Encapsulamento é um dos pilares fundamentais da programação orientada a
objetos que consiste em:

    - Ocultar os detalhes internos de implementação de uma classe
      Agrupar dados e métodos relacionados em uma única unidade (classe)
    - Controlar o acesso aos atributos através de métodos públicos
      (getters/setters)
    - Proteger a integridade dos dados através de validações

    Benefícios:
    - Manutenibilidade do código
    - Reutilização de componentes
    - Redução de acoplamento
    - Maior segurança dos dados

    Exemplo prático - Encapsulamento:

    javac -d Classes ContaBancaria.java && java -cp Classes ContaBancaria
*/
public class ContaBancaria {
    private double saldo; // Atributo privado
    private String numeroConta;

    public ContaBancaria(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    // Métodos públicos para acessso controlado
    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContaBancaria minhaConta = new ContaBancaria("12345-6", 1000.00);

        System.out.println("Saldo inicial da conta " + minhaConta.numeroConta + ": R$" + minhaConta.getSaldo());

        minhaConta.depositar(500.00);
        System.out.println("Saldo após depósito de R$500.00: R$" + minhaConta.getSaldo());

        if (minhaConta.sacar(200.00)) {
            System.out.println("Saque de R$200.00 realizado com sucesso.");
        } else {
            System.out.println("Saque de R$200.00 falhou. Saldo insuficiente.");
        }

        System.out.println("Saldo final: R$" + minhaConta.getSaldo());
    }
}
