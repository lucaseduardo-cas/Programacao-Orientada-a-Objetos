/*  
Exceções Verificadas (Checked):
    O compilador obriga que sejam tratadas,
    pois a chance de ocorrerem é alta em
    situações previsíveis.
    
    - O compilador força a usar 'try-catch'
      ou declarar 'throws' no método.
    - Herdam da classe 'Exception'.
    - Exemplo: 'FileNotFoundException'
      e 'IOException' ao trabalhar com arquivos.

    javac -d Classes ExemploCheckedException.java && java -cp Classes ExemploCheckedException
*/


// Exercício – Exemplo de Exceção verificada
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ExemploCheckedException {

    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("arquivo.txt");
            BufferedReader fileInput = new BufferedReader(file);
            
            String line = fileInput.readLine();
            
            System.out.println(line);
            
            fileInput.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
