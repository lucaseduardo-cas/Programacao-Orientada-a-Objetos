/* 
POLIMORFISMO DE VARIÁVEIS

Definições:
    - Polimorfismo significa "muitas formas" - capacidade de um objeto assumir
      múltiplas formas
    - Polimorfismo de variáveis permite que uma variável da superclasse
      referencie objetos de subclasses
    - O tipo declarado da variável pode ser diferente do tipo real do objeto
    - Permite tratar objetos de diferentes classes de forma uniforme
    - Facilita extensibilidade - novos tipos podem ser adicionados sem alterar
      código existente
    - Base para programação genérica e padrões de design 
 
*/

public class ExemploPolimorfismo {
    public static void main(String[] args) {
        // Polimorfismo: variaveis da superclasse referenciam subclasses
        Funcionario func1 = new Funcionario("Joao", 3000);
        Funcionario func2 = new Gerente("Maria", 5000, 2000);

        // Mesma variavel, comportamentos diferentes
        System.out.println("Salario Joao: " + func1.calcularSalario());
        System.out.println("Salario Maria: " + func2.calcularSalario());

        func1.trabalhar();
        func2.trabalhar(); // "Maria gerenciando equipe"

        // Array polimorfico
        Funcionario[] equipe = {
            new Funcionario("Ana", 2800),
            new Gerente("Carlos", 6000, 1500)
        };

        double total = 0;
        for (Funcionario f : equipe) {
            total += f.calcularSalario(); // Polimorfismo em acao
        }
        System.out.println("Folha total: R$ " + total);
    }
}

// Classe base
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

// Classe derivada que sobrescreve metodos
class Gerente extends Funcionario {
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
}