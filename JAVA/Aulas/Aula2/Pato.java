/* 
HERANÇA MÚLTIPLA

Definições:
    - Herança múltipla permite que uma classe herde de mais de uma superclasse
    - Java não suporta herança múltipla de classes para evitar ambiguidades
    - Em Java, simula-se através de interfaces - uma classe pode implementar
      múltiplas interfaces
    - Interface define um contrato de métodos que devem ser implementados
    - Resolve o problema do "diamante" presente em linguagens com herança
      múltipla real
    - Permite que uma classe tenha múltiplos "tipos" ou comportamentos

UML - HERANÇA MÚLTIPLA

+---------------------+      +---------------------+     +---------------------+
|    <<interface>>    |      |        ANIMAL       |     |     <<interface>>   |
|        VOADOR       |      | nome                |     |      Nadador        |
+---------------------+      +---------------------+     +---------------------+
|      +voar()        |      |                     |     |     +nadar()        |
+---------------------+      +---------------------+     +---------------------+
                  \                      |                    /
                   \                     |                   /  
                    \                    |                  / 
                     \                   |                 /
                      \                  |                /
                       \                 |               /
                        \                |              /
                         \               |             /
                          \              |            /
                           \             |           /
                            \            |          /
                             \           |         /
                              \          |        /
                             +---------------------+
                             |         PATO        |
                             +---------------------+
                             +---------------------+
                             | +vaar()             |
                             | +nadar()            |
                             +---------------------+  
*/

// Interfaces (simulam herança múltipla em Java)
interface Voador {
    void voar();
}

interface Nadador {
    void nadar();
}

// Classe base
// public class Animal {
class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }
}

// Classe que implementa múltiplas interfaces
public class Pato extends Animal implements Voador, Nadador {
    public Pato(String nome) {
        super(nome);
    }

    @Override
    public void voar() {
        System.out.println(nome + " está voando");
    }

    @Override
    public void nadar() {
        System.out.println(nome + " está nadando");
    }

    public static void main(String[] args) {
        // Criando um objeto da classe Pato
        Pato pato = new Pato("Donald");

        // Demonstrando os metodos das interfaces
        pato.voar();
        pato.nadar();
    }
}
