/* 
POLIMORFISMO EM MENSAGENS

Definições:
    - Polimorfismo em mensagens refere-se à capacidade de enviar a mesma
      mensagem para objetos diferentes
    - Cada objeto responde à mensagem de acordo com sua implementação
      específica
    - A mesma interface produz comportamentos diferentes dependendo do
      tipo do objeto
    - Implementado através de métodos virtuais e ligação dinâmica
    - Permite código mais flexível e desacoplado
    - Essencial para inversão de dependência e programação orientada a
      interfaces
*/

// Comando para compilar e executar o código
// javac -d Classes ExemploPolimorfismoMensagens.java && java -cp Classes ExemploPolimorfismoMensagens

// Comando para compilar e executar o código
// javac -d Classes ExemploPolimorfismoMensagens.java && java -cp Classes ExemploPolimorfismoMensagens

import java.lang.Math;

// Interface comum
interface Forma {
    double calcularArea();
    void desenhar();
}

// Implementações específicas
class Retangulo implements Forma {
    private double largura, altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando retangulo " + largura + "x" + altura);
    }
}

class Circulo implements Forma {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando circulo raio " + raio);
    }
}

public class TesteFomas {
    public static void main(String[] args) {
        Forma[] formas = {new Retangulo(5, 3), new Circulo(4)};
        
        for (Forma f : formas) {
            f.desenhar();
            System.out.println("Área: " + f.calcularArea());
        }
    }
}