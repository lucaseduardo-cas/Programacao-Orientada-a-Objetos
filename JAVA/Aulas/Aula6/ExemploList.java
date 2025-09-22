import java.util.*;

public class ExemploList {
    public static void main(String[] args) {
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
        nomes.remove(0); // Remover por índice
        
        // Busca
        boolean tem = nomes.contains("Maria");
        int indice = nomes.indexOf("Maria");
        System.out.println("Contém Maria: " + tem);
        System.out.println("Índice: " + indice);
    }
}