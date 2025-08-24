/*
SOBRESCRITA DE MÉTODOS

Definições:
    - Sobrescrita (Override) permite que uma subclasse redefina um método
      herdado da superclasse
    - O método sobrescrito deve ter a mesma assinatura (nome, parâmetros, tipo
      de retorno)
    - Usa-se a anotação @Override em Java para indicar sobrescrita explícita
    - Implementa ligação dinâmica - o método executado depende do tipo real do
      objeto
    - Permite especialização do comportamento nas subclasses
    - Fundamental para implementar polimorfismo efetivo
*/

// Classe base
// public class Funcionario {
class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double calcularSalario() {
        return salario;
    }

    public void trabalhar() {
        System.out.println(nome + " trabalhando");
    }
}

// Classe derivada que sobrescreve métodos
public class Gerente extends Funcionario {
    private double bonus;

    public Gerente(String nome, double salario, double bonus) {
        super(nome, salario);
        this.bonus = bonus;
    }

    @Override
    public double calcularSalario() {
        return salario + bonus; // Sobrescrita
    }

    @Override
    public void trabalhar() {
        System.out.println(nome + " gerenciando equipe");
    }

    public static void main(String[] args) {
        // Criando um objeto da classe Funcionario
        Funcionario funcionario = new Funcionario("João", 3000.0);
        System.out.println("--- Funcionario ---");
        funcionario.trabalhar();
        System.out.println("Salario: " + funcionario.calcularSalario());
        System.out.println();

        // Criando um objeto da classe Gerente
        Gerente gerente = new Gerente("Maria", 5000.0, 1000.0);
        System.out.println("--- Gerente ---");
        gerente.trabalhar();
        System.out.println("Salario: " + gerente.calcularSalario());
    }
}