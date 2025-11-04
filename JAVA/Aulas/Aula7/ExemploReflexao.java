/*
Conceito de reflexão

- Reflexão: Capacidade de um programa examinar e modificar sua própria
  estrutura e comportamento em tempo de execução
- API de Reflexão: Conjunto de classes e métodos que permitem introspecção
  de classes, métodos, campos e construtores
- Metadados: Informações sobre a estrutura do código (classes, métodos,
  atributos) disponíveis em runtime
- Class object: Objeto que representa uma classe em tempo de execução,
  permitindo acesso aos seus metadados

javac -d Classes ExemploReflexao.java && java -cp Classes ExemploReflexao
*/

public class ExemploReflexao {
    public static void main(String[] args) {
        // Obtendo informações da classe String
        Class<?> clazz = String.class;

        System.out.println("Classe: " + clazz.getName());
        System.out.println("Métodos: " + clazz.getMethods().length);
        System.out.println("Campos: " + clazz.getFields().length);

        // Verificando se é uma classe ou interface
        System.out.println("É interface? " + clazz.isInterface());
    }
}
