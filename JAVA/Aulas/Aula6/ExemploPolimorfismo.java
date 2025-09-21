// Classe pai do ExemploObjeto.java
class Pessoa {
    private String nome;
    private int idade;

    // Construtor adicionado para inicializar nome e idade
    public Pessoa(String nome, int idade) {
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
    Herança

    Definições: Herança é o mecanismo que permite criar uma nova classe (filha/subclasse) baseada em uma classe 
    existente (pai/superclasse), herdando seus atributos e métodos promovendo reutilização de código e hierarquias 
    de classes.
*/

class PessoaJuridica extends Pessoa { // Class PessoaJuridica herda da Class Pessoa
    private int tempoAtividade;

    // O construtor deve chamar o construtor da classe pai (Pessoa)
    public PessoaJuridica(String nome, int tempoAtividade) {
        super(nome, 0); // Chama o construtor da classe pai e define a idade como 0
        this.tempoAtividade = tempoAtividade;
    }
    
    @Override
    public void apresentar() {
        // Usa getNome() para acessar o nome da classe pai, pois a variável é privada
        System.out.println("Sou a empresa " + getNome() + ", atuando há " + tempoAtividade + " anos.");
    }
}

/* 
    Polimorfismo

    Polimorfismo é a capacidade de objetos de diferentes classes responderem de forma específica a um método. Permite 
    que um mesmo código trabalhe com diferentes tipos de objetos de forma transparente.
*/
public class ExemploPolimorfismo {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("João", 25);
        Pessoa p2 = new Pessoa("Maria", 30);
        Pessoa p3 = new PessoaJuridica("ACME SA", 10);

        p1.apresentar();
        p2.apresentar();
        p3.apresentar();

        System.out.println(p1.getNome());
        System.out.println(p2.getNome());
    }
}