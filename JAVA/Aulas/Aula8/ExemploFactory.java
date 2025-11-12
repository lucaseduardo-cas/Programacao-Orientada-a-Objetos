/* 
Factory
- Encapsulamento da criação: Isola o código de criação de objetos do código
  que os utiliza
- Factory Method: Padrão que cria objetos sem especificar suas classes exatas
- Abstract Factory: Fornece interface para criar famílias de objetos
  relacionados

javac -d Classes ExemploFactory.java && java -cp Classes ExemploFactory
*/

// Classe base do objeto a ser criado
class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
    }
}

// 1. Fábrica (Factory)
class PessoaFactory {
    // Método estático que encapsula a lógica de criação do objeto Pessoa
    public static Pessoa criarPessoa(String nome, int idade) {
        // Factory Method: Cria e retorna a instância de Pessoa
        return new Pessoa(nome, idade);
    }
}

// 2. Cliente (Exemplo de uso)
public class ExemploFactory {
    public static void main(String[] args) {
        // Uso direto do construtor (NÃO é a prática Factory)
        Pessoa joao = new Pessoa("João", 30);
        
        // Uso do Factory Method (BOA PRÁTICA)
        Pessoa maria = PessoaFactory.criarPessoa("Maria", 25);
        
        System.out.println("--- Padrão Factory Method ---");
        System.out.println("Criação Direta: " + joao);
        System.out.println("Criação via Factory: " + maria);
    }
}
