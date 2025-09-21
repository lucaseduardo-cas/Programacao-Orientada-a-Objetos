/* 
LIST

É uma interface da Java Collections Framework que representa uma coleção
ordenada:
    - Permite elementos duplicados na coleção
    - Mantém a ordem de inserção dos elementos
    - Acesso por índice - permite acesso direto aos elementos através de posição

Características:
    - Redimensionamento dinâmico
    - Métodos para adicionar, remover e buscar elementos
    - Suporte a iteração sequencial
    - Permite valores nulos
*/

// javac -d Classes ExemploList.java && java -cp Classes ExemploList
import java.util.ArrayList;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) {
        // Criação de uma lista com ArrayList
        List<String> nomes = new ArrayList<>();

        // Adicionando elementos
        nomes.add("João");
        nomes.add("Maria");
        nomes.add("Pedro");
        nomes.add("Maria"); // Permite duplicatas

        // Operações principais
        System.out.println("Primeiro: " + nomes.get(0));
        System.out.println("Tamanho: " + nomes.size());

        nomes.set(1, "Ana"); // Substituir
        nomes.remove("Pedro"); // Remover por valor
        nomes.remove(0); // Remover por indice

        // Busca
        boolean tem = nomes.contains("Maria");
        int indice = nomes.indexOf("Maria");

        System.out.println("Contém Maria: " + tem);
        System.out.println("Índice: " + indice);
    }
}
