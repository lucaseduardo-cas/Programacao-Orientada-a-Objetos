/* 
HERANÇA

Definições: Herança é o mecanismo que permite criar uma nova classe
(filha/subclasse) baseada em uma classe existente (pai/superclasse),
herdando seus atributos e métodos, promovendo reutilização de código e
hierarquias de classes.
Exemplos práticos
Diagramas UML quando aplicável
*/

// Classe pai
public class Veiculo {
    protected String marca;
    protected boolean ligado;

    public Veiculo(String marca) {
        this.marca = marca;
        this.ligado = false;
    }

    public void ligar() {
        ligado = true;
        System.out.println(marca + " ligado!");
    }

    public void acelerar() {
        System.out.println("Acelerando...");
    }
}
