// javac -d Classes TestePolimorfismo.java && java -cp Classes TestePolimorfismo

package JAVA.Exemplos;

// Classe base
class Animal {
    void fazerSom() {
        System.out.println("O animal faz um som");
    }
}

// Subclasse 1
class Cachorro extends Animal {
    @Override
    void fazerSom() {
        System.out.println("O cachorro late");
    }
}

// Subclasse 2
class Gato extends Animal {
    @Override
    void fazerSom() {
        System.out.println("O gato mia");
    }
}

// Classe principal para testar o polimorfismo
public class TestePolimorfismo {
    public static void main(String[] args) {
        Animal meuAnimal = new Animal();
        Animal meuCachorro = new Cachorro();
        Animal meuGato = new Gato();

        meuAnimal.fazerSom();     // Saída: O animal faz um som
        meuCachorro.fazerSom();   // Saída: O cachorro late
        meuGato.fazerSom();       // Saída: O gato mia
    }
}