/* 
    Encapsulamento

    Encapsulamento é o princípio de
    ocultar os detalhes internos de uma
    classe e expor apenas o que é
    necessário. Permite controlar o acesso
    aos dados e proteger a integridade do
    objeto. Exemplo: Os atributos são
    geralmente privados, e o acesso a eles
    é feito através de métodos públicos
    (getters e setters).
*/

// A classe ContaCorrente para demonstrar o encapsulamento
class ContaCorrente {
    private double saldo;
    private String senha;

    public ContaCorrente(String senha) {
        this.senha = senha;
        this.saldo = 0.0;
    }

    public double getSaldo(String senhaInformada) {
        if (senha.equals(senhaInformada)) {
            return saldo;
        }
        return -1; // senha incorreta
    }

    public void depositar(double valor) {
        double valorFinal = this.saldo + valor;
        this.saldo = valorFinal;
    }
}

// A classe para testar o código
public class TesteConta {
    public static void main(String[] args) {
        // Crie uma nova conta com uma senha
        ContaCorrente minhaConta = new ContaCorrente("1234");
        
        System.out.println("Saldo inicial da conta: " + minhaConta.getSaldo("1234"));

        // Teste o método de depósito
        minhaConta.depositar(500.0);
        System.out.println("Saldo após o depósito de R$500,00: " + minhaConta.getSaldo("1234"));

        // Tente acessar o saldo com a senha incorreta
        System.out.println("Tentando pegar o saldo com a senha incorreta: " + minhaConta.getSaldo("9999"));

        // Deposite mais um valor
        minhaConta.depositar(250.0);
        System.out.println("Saldo após um segundo depósito: " + minhaConta.getSaldo("1234"));
    }
}