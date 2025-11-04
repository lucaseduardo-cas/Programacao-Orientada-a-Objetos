/* 
Boas práticas

Conteúdo teórico detalhado sobre Boas práticas.
- Cache de objetos Class: Evitar chamadas repetidas a Class.forName()
  armazenando resultados
- Tratamento de exceções: Capturar adequadamente
  ReflectiveOperationException e suas subclasses
- Validação de segurança: Verificar permissões antes de usar setAccessible()
- Performance: Usar reflexão apenas quando necessário, pois é mais lenta que
  chamadas diretas
- Tipo de retorno: Fazer cast seguro dos resultados de invoke() e newInstance()
- Documentação: Documentar claramente o uso de reflexão no código para
  facilitar manutenção

javac -d Classes ExemploBoasPraticas.java && java -cp Classes ExemploBoasPraticas
*/

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;

public class ExemploBoasPraticas {
    
    // Cache para evitar Class.forName repetido (Boa Prática de Cache)
    private static final Map<String, Class<?>> cache = new HashMap<>();

    // Boa Prática: Obter a classe de forma segura e usar o cache
    private static Class<?> getClassSafely(String className) {
        return cache.computeIfAbsent(className, name -> {
            try {
                return Class.forName(name);
            } catch (ClassNotFoundException e) {
                // Boa Prática: Propagar exceções verificadas como RuntimeException
                throw new RuntimeException("Classe não encontrada: " + name, e);
            }
        });
    }

    // Boa Prática: Invocar método de forma segura
    private static Object invokeMethodSafely(Object target, String methodName) {
        try {
            // Obtém o método. length() não tem parâmetros, então não precisamos de classes de parâmetros.
            Method method = target.getClass().getMethod(methodName);
            // Invoca o método no objeto 'target'
            return method.invoke(target);
        } catch (Exception e) {
            // Boa Prática: Tratamento de exceções específico e relançamento como RuntimeException
            throw new RuntimeException("Erro ao invocar: " + methodName, e);
        }
    }

    public static void main(String[] args) {
        try {
            // 1. Boa prática: Cache de classes
            // Obtendo a classe String de forma segura
            Class<?> stringClass = getClassSafely("java.lang.String");
            
            // 2. Boa prática: Tratamento de exceções (usando o invokeMethodSafely)
            String text = "test"; // Objeto de teste
            
            // Invocando o método length() no objeto "test"
            Object resultado = invokeMethodSafely(text, "length");
            
            System.out.println("Comprimento: " + resultado);
            
        } catch (RuntimeException e) {
            // Captura o RuntimeException lançado pelos métodos auxiliares
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
