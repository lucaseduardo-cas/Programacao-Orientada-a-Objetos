/*
    RuntimeException

    Definições:
        - 'RuntimeException' é a superclasse de todas as exceções que podem ser lançadas durante a execução 
          normal do programa
        - São 'unchecked exceptions', ou seja, não precisam ser declaradas ou capturadas
        - Exemplos comuns: NullPointerException, IllegalArgumentException, ArrayIndexOutOfBoundsException
        - Geralmente indicam erros de programação, como acesso a referências nulas ou índices inválidos
        - Devem ser evitadas com boas práticas de codificação e validação de entrada
        - Podem ser lançadas explicitamente  com  throw  quando necessário. 

    javac -d Classes ExemploRuntimeException.java && java -cp Classes ExemploRuntimeException
*/

// Exemplo prático de RuntimeException
public class ExemploRuntimeException {
    public static void main(String[] args) {
        // String texto = null;
        String texto = "exemplo"; // Se atribuir "null" a variável texto, como no exemplo original, gera aviso
        int[] numbers = {1, 2, 3};

        System.out.println(texto.length()); // Lança NullPointerException
        System.out.println(5 / 0);          // Lança ArithmeticException
        System.out.println(numbers[3]);     // Lança ArrayIndexOutOfBoundsException
    }
}
