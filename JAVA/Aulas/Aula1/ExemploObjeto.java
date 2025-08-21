/*
OBJETO

Conteúdo teórico detalhado sobre Objeto.
- Definições: Objeto é uma instância de uma classe, uma entidade concreta
criada a partir do modelo da classe. Cada objeto possui seu próprio estado
(valores dos atributos) e pode executar os comportamentos definidos na
classe.
- Exemplos práticos
- Diagramas UML quando aplicável
*/

/*
- mkdir Classes
- javac -d Classes Pessoa.java ExemploObjeto.java 
- java -cp Classes ExemploObjeto  
*/

public class ExemploObjeto {
    public static void main(String[] args) {
        // Criando objetos (instâncias)
        Pessoa p1 = new Pessoa ("João", 25);
        Pessoa p2 = new Pessoa ("Maria", 30);

        // Usando os objetos
        p1.apresentar(); // Sou João, 25 anos;
        p2.apresentar(); // Sou maria, 30 anos;

        // Cada objeto tem seu próprio estado
        System.out.println(p1.getNome()); // João
        System.out.println(p2.getNome()); // Maria
    }
}

