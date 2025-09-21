/*
Introdução
    - Coleções: estruturas de dados que armazenam múltiplos elementos.
    - Generics: mecanismo para criar classes, interfaces e métodos parametrizados
      por tipo.
    - Importância: facilitam o gerenciamento de dados, promovem reuso e
    aumentam a segurança de tipos.
    - Aplicações: listas, conjuntos, mapas, filas, pilhas, etc.
    - Java Collections Framework: conjunto de classes e interfaces para
      manipulação de coleções.
   
Generics em Java
    - Generics: são um mecanismo que permite criar classes, interfaces e métodos
      parametrizados por tipo:
    - Type Safety: detecta erros de tipo em tempo de compilação
    - Eliminação de casts: não precisa fazer casting explícito
    - Reutilização de código: mesmo código funciona com diferentes tipos

    Características:
    - Avançado: Wildcards (?, ? extends, ? super)
    - Não permite tipos primitivos diretamente
*/

// javac -d Classes ExemploGenerics.java && java -cp Classes ExemploGenerics
import java.util.ArrayList;
import java.util.List;

// Classe genérica
class Caixa<T> {
    private T conteudo;
    public void colocar(T item) { this.conteudo = item; }
    public T retirar() { return conteudo; }
}

public class ExemploGenerics {
    public static void main(String[] args) {
        // Uso da classe genérica
        Caixa<String> caixaTexto = new Caixa<>();
        caixaTexto.colocar("Olá");
        String texto = caixaTexto.retirar(); // Sem cast
        System.out.println("Conteúdo da caixa: " + texto);

        // Coleções com generics
        List<String> nomes = new ArrayList<>();
        nomes.add("João");
        // nomes.add(123); // Erro de compilação

        // Wildcards
        List<Integer> numeros = new ArrayList<>();
        // numeros.add("4"); // Erro de compilação
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        System.out.println("Conteúdo da lista de números: " + numeros);
    }
}
