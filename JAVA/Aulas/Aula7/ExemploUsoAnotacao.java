/*
Casos de uso

- Frameworks: Utilizam reflexão para injeção de dependência e mapeamento
  objeto-relacional
- Serialização: Conversão de objetos para formatos como JSON, XML usando
  reflexão
- Testes unitários: Ferramentas como JUnit usam reflexão para descobrir e
  executar métodos de teste
- Anotações: Processamento de metadados em tempo de execução (@Entity,
  @Service, etc.)
- Plugins: Carregamento dinâmico de funcionalidades sem conhecimento
  prévio das classes
- APIs genéricas: Criação de código que funciona com qualquer tipo de objeto

javac -d Classes ExemploUsoAnotacao.java && java -cp Classes ExemploUsoAnotacao
*/

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// 1. Definição da Anotação (Interface)
// @Retention(RetentionPolicy.RUNTIME) garante que a anotação estará disponível em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
@interface Executar {}

// 2. Classe com a tarefa a ser executada
class Servico {
    
    // Método marcado para execução
    @Executar
    public void tarefa1() {
        System.out.println("Executando tarefa 1");
    }

    // Método que NÃO está marcado
    public void tarefa2() {
        System.out.println("Executando tarefa 2 (Ignorada)");
    }
    
    // Método marcado para execução
    @Executar
    public void tarefa3() {
        System.out.println("Executando tarefa 3");
    }
}

public class ExemploUsoAnotacao {
    // A declaração 'throws Exception' é necessária para Method.invoke()
    public static void main(String[] args) throws Exception {
        Servico servico = new Servico();

        System.out.println("--- Execução Condicional de Métodos (Reflexão) ---");

        // Executar apenas métodos anotados com @Executar
        // 1. Itera sobre todos os métodos da classe Servico
        for (Method m : servico.getClass().getDeclaredMethods()) {
            
            // 2. Verifica se o método possui a anotação @Executar
            if (m.isAnnotationPresent(Executar.class)) {
                System.out.print("[ANOTADO] ");
                // 3. Invoca o método dinamicamente
                m.invoke(servico);
            }
        }
    }
}
