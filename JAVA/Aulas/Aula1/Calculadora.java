/*
MÉTODOS

Definições: Métodos são funções que definem os comportamentos de uma
classe/objeto. Representam as ações que o objeto pode realizar, podendo
receber parâmetros, retornar valores e modificar o estado do objeto.
Exemplos práticos
Diagramas UML quando aplicável
*/

/*
- javac -d Classes Calculadora.java 
- java -cp Classes Calculadora  
*/

public class Calculadora {
    // Método sem retorno
    public void ligar() {
        System.out.println("Calculadora ligada!");
    }

    // Método com retorno
    public double soma (double a, double b) {
        return a + b;
    }

    // Método estático
    public static double elevar (double base, int exp) {
        return Math.pow(base, exp);
    }

    // Sobrecarregar métodos
    public double multiplicar (double a, double b) {
        return a * b;
    }
    public double multiplicar (double a, double b, double c) {
        return a * b * c;
    }

    // Ponto de entrada
    public static void main(String[] args) {
        // Criar objeto
        Calculadora calc = new Calculadora();

        // Testar métodos
        calc.ligar();

        System.out.println("Soma: " + calc.soma(10, 5));
        System.out.println("Multiplicação 2 valores: " + calc.multiplicar(3, 4));
        System.out.println("Multiplicação 3 valores: " + calc.multiplicar(2, 3, 4));

        // Chamando método estático
        System.out.println("Elevar 2^3: " + Calculadora.elevar(2, 3));
    }
}