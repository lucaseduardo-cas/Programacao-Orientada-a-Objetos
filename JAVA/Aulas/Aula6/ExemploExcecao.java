/* 
    Tratamento de Exceções em Orientação a
    Objetos

    Tratamento de exceções é um mecanismo para lidar com erros ou condições excepcionais 
    que ocorrem durante a execução de um programa. Em POO, isso é feito usando blocos 
    try-catch-finally para capturar e tratar exceções, garantindo que o programa possa 
    continuar a funcionar ao invés de falhar abruptamente.

    Tipos de exceções
        - Checked Exceptions: devem ser tratadas obrigatoriamente.
        - Unchecked Exceptions: não precisam ser declaradas.
*/

class ContaCorrente {
    private String senha;
    private double saldo = 1000.00; // Saldo inicial para o exemplo

    // Construtor para inicializar a conta com uma senha
    public ContaCorrente(String senha) {
        this.senha = senha;
    }

    public double getSaldo(String senhaInformada) {
    if (senha.equals(senhaInformada)) {
        return saldo;
    }
    //return -1; // senha incorreta
        throw new IllegalArgumentException("Senha incorreta");
    }
}

public class ExemploExcecao {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("1234");
        try {
            double saldo = conta.getSaldo("0000");
            System.out.println("Saldo: " + saldo);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Operação finalizada.");
        }
    }
}
