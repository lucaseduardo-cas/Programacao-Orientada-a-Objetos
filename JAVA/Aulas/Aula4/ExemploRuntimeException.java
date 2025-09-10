/*
  
    javac -d Classes ExemploRuntimeException.java && java -cp Classes ExemploRuntimeException
*/

// Exemplo prático de RuntimeException
public class ExemploRuntimeException {
    public static void main(String[] args) {
        String texto = null;
        int[] numbers = {1, 2, 3};

        System.out.println(texto.length()); // Lança NullPointerException
        System.out.println(5 / 0);          // Lança ArithmeticException
        System.out.println(numbers[3]);     // Lança ArrayIndexOutOfBoundsException
    }
}
