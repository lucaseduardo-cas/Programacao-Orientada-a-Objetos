/* 
Manipulação de classes em runtime

Conteúdo teórico detalhado sobre Manipulação de classes em runtime.

Definições
- Invocação dinâmica: Chamada de métodos através de reflexão usando
  Method.invoke()
- Instanciação dinâmica: Criação de objetos usando
  Constructor.newInstance()
- Acesso a campos: Leitura e escrita de atributos usando Field.get() e Field.set()
- Modificadores de acesso: Controle de visibilidade (public, private, protected)
  que pode ser contornado com setAccessible()
- ClassLoader: Mecanismo responsável por carregar classes dinamicamente

javac -d Classes ExemploManipulacao.java && java -cp Classes ExemploManipulacao
*/

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Classe a ser manipulada dinamicamente
class Calculadora {
    private int resultado = 0;

    public int somar(int a, int b) {
        this.resultado = a + b;
        return this.resultado;
    }
}

public class ExemploManipulacao {
    public static void main(String[] args) throws Exception {
// Criação dinâmica
        Class<?> clazz = Calculadora.class;
        Object calc = clazz.getDeclaredConstructor().newInstance();

        // Invocação dinâmica de método
        Method somar = clazz.getMethod("somar", int.class, int.class);
        Object resultado = somar.invoke(calc, 10, 5);
        System.out.println("Resultado: " + resultado);

        // Acesso a campo privado
        Field campo = clazz.getDeclaredField("resultado");
        campo.setAccessible(true);
        System.out.println("Campo privado: " + campo.get(calc));
    }
}
