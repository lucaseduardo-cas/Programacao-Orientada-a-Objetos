/* 
UML - VISÃO GERAL

Conteúdo teórico detalhado sobre UML – Visão Geral.
Definições: UML (Unified Modeling Language) é uma linguagem de
modelagem padrão para visualizar, especificar, construir e documentar
sistemas orientados a objetos através de diagramas que representam
diferentes aspectos do sistema.

HERANÇA SIMPLES
Definições:
    - Herança é um mecanismo que permite criar uma nova classe baseada em
    uma classe existente
    - A classe base (superclasse) define atributos e métodos comuns
    - A classe derivada (subclasse) herda características da superclasse e pode
      adicionar novas ou modificar existentes
    - Promove reutilização de código e estabelece relacionamentos hierárquicos
    - Em Java, usa-se a palavra-chave extends para implementar herança
    - Suporta o princípio "é um" - subclasse "é um" tipo da superclasse
*/

// Classe base (superclasse)
class Veiculo {
    protected String marca;
    protected int ano;

    public Veiculo(String marca, int ano) {
        this.marca = marca;
        this.ano = ano;
    }

    public void acelerar() {
        System.out.println("Veiculo acelerando...");
    }

    public String getInfo() {
        return marca + " (" + ano + ")";
    }
}

// Classe derivada (subclasse)
public class Carro extends Veiculo {
    private int portas;

    public Carro(String marca, int ano, int portas) {
        super(marca, ano);
        this.portas = portas;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " - " + portas + " portas";
    }

    public static void main(String[] args) {
        // Criando um objeto da classe base
        Veiculo veiculo = new Veiculo("Honda", 2020);
        System.out.println("Informacoes do Veiculo: " + veiculo.getInfo());
        veiculo.acelerar();

        System.out.println("--------------------");

        // Criando um objeto da classe derivada
        Carro carro = new Carro("Ford", 2022, 4);
        System.out.println("Informacoes do Carro: " + carro.getInfo());
        carro.acelerar(); // Chama o metodo da classe pai
    }
}