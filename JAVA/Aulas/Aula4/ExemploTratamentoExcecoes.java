/*
Tratamento de exceções e erros
    Definições:
    - Tratamento de erros é o processo de capturar e responder adequadamente
      a exceções
    - Substitui códigos de retorno tradicionais por um mecanismo estruturado
    - Permite propagação automática de erros através da pilha de chamadas
    - Throw: lança uma exceção quando detecta uma condição anômala
    - Catch: captura e trata exceções específicas
    - Melhora robustez e manutenibilidade do código 
 
Blocos try-catch-finally
    Definições:
    - Try: bloco onde se coloca código que pode gerar exceções
      Catch: bloco que captura e trata exceções específicas - pode haver múltiplos
      catches
    - Finally: bloco que sempre executa, independente de exceções (usado para
      limpeza)
    - Try-with-resources: sintaxe especial para recursos que implementam
      AutoCloseable
    - Permite recuperação de erros ou terminação controlada
    - Ordem dos catches: do mais específico para o mais genérico

    Sintaxe básica do tratamento de exceções:
    try {
        // Código que pode lançar exceções
    } catch (TipoDeExcecao1 e1) {
        // Tratamento para TipoDeExcecao1
    } catch (TipoDeExcecao2 e2) {
        // Tratamento para TipoDeExcecao2
    } finally {
        // Código que sempre será executado
    }
*/

// Sintaxe básica do tratamento de exceções
public class ExemploTratamentoExcecoes {

    public static void main(String[] args) {
        // Exemplo simples de tratamento de exceção
        try {
            int resultado = 10 / 0; // Isso causará uma ArithmeticException
            System.out.println("O resultado é: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Divisão por zero não é permitida.");
        } finally {
            System.out.println("Fim do programa.");
        }
    }
}
