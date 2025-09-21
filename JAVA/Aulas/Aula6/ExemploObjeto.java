/* 
    Classe, atributo e método

    - Definições: Classe é um modelo que define: - atributos e métodos

    - Atributos:  São as propriedades/características dos objetos.

    - Métodos:    São as funções ou procedimentos que descrevem os comportamentos 
                  ou ações que os objetos dessa classe podem realizar.
*/

class Pessoa { // Classe
    private String nome; // Atributo
    private int idade;

    // Construtor adicionado para inicializar nome e idade
    public Pessoa(String nome, int idade) { // Método
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentar() {
        System.out.println("Sou " + nome + ", " + idade + " anos");
    }

    public String getNome() {
        return nome;
    }

    // getNome() não é suficiente para o código rodar, então vamos adicionar um setIdade() para manter a coerência
    public void setIdade(int novaIdade) {
        this.idade = novaIdade;
    }
}

/* 
    Objeto

    Definições: Objeto é uma instância de uma classe, uma entidade concreta criada a partir do modelo da classe.
    Cada objeto possui seu próprio estado (valores dos atributos) e pode executar os comportamentos definidos na 
    classe.
*/
public class ExemploObjeto {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("João", 25); // Objeto
        Pessoa p2 = new Pessoa("Maria", 30);

        p1.apresentar();
        p2.apresentar();

        System.out.println(p1.getNome());
        System.out.println(p2.getNome());
    }
}