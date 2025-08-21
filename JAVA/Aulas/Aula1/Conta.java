/*
ATRIBUTOS

- Definições: Atributos são variáveis que representam as características ou
propriedades de uma classe/objeto. Podem ser de instância (cada objeto tem
sua própria cópia) ou de classe/estáticos (compartilhados por todos os
objetos).
- Exemplos práticos
- Diagramas UML quando aplicável
*/

/*
- mkdir Classes
- javac -d Classes Pessoa.java Conta.java 
- java -cp Classes Conta  
*/

public class Conta {
    private double saldo;

    // Atributo de classe (compartilhado)
    private static int totalContas = 0;

    public Conta (String numero) {
        this.saldo = 0.0;
        totalContas++; // Incrementa contador
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public static int getTotalContas() {
        return totalContas;
    }

    public static void main(String[] args) {
        Conta c1 = new Conta("12345");
        c1.depositar(450.35);
        System.out.println("Saldo: " + c1.saldo);
        System.out.println("Total de contas: " + Conta.getTotalContas());
    }
}