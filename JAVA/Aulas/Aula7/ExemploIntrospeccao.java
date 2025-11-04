/* 
Introspecção em Java

- Introspecção: Capacidade de examinar a estrutura interna de objetos e
  classes em tempo de execução
- Class.forName(): Método para obter o objeto Class de uma classe pelo seu
  nome
- getClass(): Método que retorna o objeto Class de uma instância
- getMethods(): Obtém array com todos os métodos públicos da classe
- getFields(): Obtém array com todos os campos públicos da classe
- getConstructors(): Obtém array com todos os construtores públicos da
  classe

javac -d Classes ExemploIntrospeccao.java && java -cp Classes ExemploIntrospeccao  
*/

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Pessoa {
    private String nome = "João";
    private int idade = 25;

    public void falar() {
        System.out.println("Falando");
    }
    
    // Construtor padrão necessário para instanciar P
    public Pessoa() {} 
}

public class ExemploIntrospeccao {
    // A declaração 'throws Exception' é necessária porque getDeclaredMethods() pode lançar exceções de segurança
    public static void main(String[] args) throws Exception { 
        Pessoa p = new Pessoa();
        // Obtendo a classe do objeto 'p'
        Class<?> clazz = p.getClass();

        System.out.println("--- Introspecção na Classe " + clazz.getSimpleName() + " ---");

        // Listar campos (Fields)
        System.out.println("\nCampos:");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println("- " + f.getName() + " (Tipo: " + f.getType().getSimpleName() + ")");
        }

        // Listar métodos (Methods)
        System.out.println("\nMétodos:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("- " + m.getName());
        }
    }
}
