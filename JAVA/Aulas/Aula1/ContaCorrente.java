/*
ENCAPSULAMENTO

Definições: Encapsulamento é o princípio de ocultar os detalhes internos de
implementação de uma classe, controlando o acesso aos atributos através de
métodos públicos (getters/setters), garantindo proteção e integridade dos
dados.
Exemplos práticos
Diagramas UML quando aplicável
*/

public class ContaCorrente {
    // Atributos privados (encapsulados)
    private double saldo;
    private String senha;

    public ContaCorrente (String senha) {
        this.senha = senha;
        this.saldo = 0.0;
    }

    // Acesso controlado ao saldo
    public double getSaldo (String senhaInformada) {
        if (senha.equals(senhaInformada)) {
            return saldo;
        }
        return -1; // Senha incorreta
    }

    // Depósito com validação
    public boolean depositar (double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContaCorrente minhaConta = new ContaCorrente("minhasenha123");
        System.out.println("Saldo com senha incorreta: " + minhaConta.getSaldo("senhaerrada"));
        System.out.println("Tentando depositar -100: " + minhaConta.depositar(-100));
        System.out.println("Depositando 250: " + minhaConta.depositar(250.0));
        System.out.println("Saldo com senha correta: " + minhaConta.getSaldo("minhasenha123"));
    }
}