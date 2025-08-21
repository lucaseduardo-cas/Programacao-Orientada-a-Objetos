/*
ABSTRAÇÃO

Definições: Abstração é o processo de identificar características essenciais de
um objeto, ignorando detalhes irrelevantes. Permite criar modelos
simplificados através de classes abstratas e interfaces, focando no "o que"
fazer ao invés de "como" fazer.
Exemplos práticos
Diagramas UML quando aplicável
*/

// Interface (abstração pura)
interface Forma {
    double calcularArea();
    void desenhar();
}

// Classe abstrata (abstração parcial)
abstract class FormaGeometrica implements Forma {
    protected String cor;

    public FormaGeometrica(String cor) {
        this.cor = cor;
    }

    public abstract void redimensionar(double fator);
}

// Implementação concreta
class Retangulo extends FormaGeometrica {
    private double largura, altura;

    public Retangulo(String cor, double l, double a) {
        super(cor);
        this.largura = l;
        this.altura = a;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando retangulo " + cor);
    }

    @Override
    public void redimensionar(double f) {
        largura *= f;
        altura *= f;
    }
}

public class ExemploAbstracao {

    public static void main(String[] args) {
        // Criando um objeto da classe Retangulo
        Retangulo retangulo = new Retangulo("Azul", 10.0, 5.0);

        // Demonstrando os metodos
        System.out.println("--- Retangulo Original ---");
        retangulo.desenhar();
        System.out.println("Area: " + retangulo.calcularArea());
        System.out.println();

        // Redimensionando o retangulo
        retangulo.redimensionar(2.0);
        System.out.println("--- Retangulo Redimensionado ---");
        retangulo.desenhar();
        System.out.println("Nova area: " + retangulo.calcularArea());
    }
}