/* 
HERANÇA

Definições: Herança é o mecanismo que permite criar uma nova classe
(filha/subclasse) baseada em uma classe existente (pai/superclasse),
herdando seus atributos e métodos, promovendo reutilização de código e
hierarquias de classes.
Exemplos práticos
Diagramas UML quando aplicável
*/

// Classe filha
public class Carro extends Veiculo {
    private int portas;

    public Carro(String marca, int portas) {
        super(marca); // Chama o construtor pai
        this.portas = portas;
    }

    @Override
    public void acelerar() {
        System.out.println("Carro acelerando suavemente");
    }

    public static void main(String[] args) {
        // Criando um objeto da classe Veiculo
        Veiculo veiculo = new Veiculo("Yamaha");
        System.out.println("--- Teste com a classe Veiculo ---");
        veiculo.ligar();
        veiculo.acelerar();
        System.out.println();

        // Criando um objeto da classe Carro
        Carro carro = new Carro("Ford", 4);
        System.out.println("--- Teste com a classe Carro ---");
        carro.ligar();
        carro.acelerar(); // O método da classe filha será chamado
    }
}