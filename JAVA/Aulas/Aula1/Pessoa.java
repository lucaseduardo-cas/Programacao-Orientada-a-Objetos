/* 
CLASSE

Definições: Classe é um modelo ou template que define as características
(atributos) e comportamentos (métodos) que os objetos desse tipo terão. É
como uma "planta" para criar objetos.
Exemplos práticos
Diagramas UML quando aplicável
*/

/*
- mkdir Classes
- javac -d Classes Pessoa.java Pessoa.java 
- java -cp Classes Pessoa  
*/

// Definição de classe simples
public class Pessoa {
    private String nome;
    private int idade;
    
    // Construtor
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    // Método
    public void apresentar() {
        System.out.println("Sou " + nome + "," + idade + " anos");
    }

    // Getter
    public String getNome() {
        return nome;
    }

    // Ponto de entrada
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Lucas", 26);
        p1.apresentar();
    }
}