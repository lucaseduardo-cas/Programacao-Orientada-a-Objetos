/*
Boas práticas de tratamento

Definições:
    - Não ignore exceções: sempre trate ou propague adequadamente.
    - Seja específico: capture exceções específicas, não genéricas (Exception).
    - Falhe rápido: detecte erros o mais cedo possível.
    - Mensagens informativas: forneça contexto útil para depuração.
    - Cleanup: sempre libere recursos (use try-with-resources quando possível).

    javac -d Classes ExemploBoasPraticas.java && java -cp Classes ExemploBoasPraticas
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExemploBoasPraticas {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("arquivo.txt"))) {
            String linha = br.readLine();
            System.out.println("Primeira linha: " + linha);
        } catch (IOException e) {
            System.out.println("Erro ao acessar arquivo: " + e.getMessage());
        }
    }
}
