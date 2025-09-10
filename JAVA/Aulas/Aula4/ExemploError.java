/*
Error

O Error é uma subclasse de Throwable que indica problemas graves do sistema
que geralmente não podem ser tratados ou recuperados. Exemplos comuns
incluem:

    - OutOfMemoryError: quando a JVM fica sem memória
    - StackOverflowError: quando a pilha de chamadas excede seu limite
    - VirtualMachineError: erros relacionados à máquina virtual Java
    
    javac -d Classes ExemploError.java && java -cp Classes ExemploError
*/

// Exemlo prático de Error
public class ExemploError {
    public static void main(String[] args) {
        // Exemplo de StackOverflowError
        try {
            metodoRecursivo();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError capturado: " + e.getMessage());
        }
    }
    public static void metodoRecursivo() {
        metodoRecursivo(); // Chamada recursiva infinita
    }
}
