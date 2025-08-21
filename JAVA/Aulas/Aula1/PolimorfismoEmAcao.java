/* 
POLIMORFISMO

Definições: Polimorfismo é a capacidade de objetos de diferentes classes
responderem de forma específica a uma mesma mensagem/método. Permite
que um mesmo código trabalhe com diferentes tipos de objetos de forma
transparente.
Exemplos práticos
Diagramas UML quando aplicável
*/

// Classe abstrata
abstract class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public abstract void emitirSom(); // Metodo abstrato
}

// Subclasses
class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " Au au!");
    }
}

class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " Miauu!");
    }
}

public class PolimorfismoEmAcao {
    public static void main(String[] args) {
        // Polimorfismo em acao
        Animal[] animais = {new Cachorro("Rex"), new Gato("Mimi")};
        for (Animal a : animais) {
            a.emitirSom(); // Comportamento especifico
        }
    }
}