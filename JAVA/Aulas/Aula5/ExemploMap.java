/* 
MAP

Map é uma interface que representa uma coleção de pares chave-valor:
    - Associa chaves únicas a valores - cada chave mapeia para um valor
    - Não permite chaves duplicadas - mas valores podem se repetir
    - Implementações principais: HashMap, LinkedHashMap, TreeMap
    - Não é uma Collection - é uma interface separada

Características:
    - HashMap: melhor performance, sem ordem
    - LinkedHashMap: mantém ordem de inserção
    - TreeMap: chaves ordenadas naturalmente
    - Acesso rápido por chave (O(1) para HashMap)
*/

// javac -d Classes ExemploMap.java && java -cp Classes ExemploMap
import java.util.HashMap;
import java.util.Map;

public class ExemploMap {
    public static void main(String[] args) {
        Map<String, Integer> idades = new HashMap<>();

        // Adicionando pares chave-valor
        idades.put("João", 25);
        idades.put("Maria", 30);
        idades.put("Pedro", 26);
        idades.put("João", 26); // Atualiza o valor existente para a chave "João"

        // Acessando valores pela chave
        System.out.println("Idade de João: " + idades.get("João"));

        // Verificações
        boolean temPedro = idades.containsKey("Pedro");
        boolean tem30 = idades.containsValue(30);

        System.out.println("O mapa contém a chave 'Pedro'? " + temPedro);
        System.out.println("O mapa contém o valor 30? " + tem30);

        // Iterando sobre o Map
        System.out.println("\nIterando sobre o mapa:");
        for (Map.Entry<String, Integer> entry : idades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Operações úteis
        idades.remove("Maria");
        System.out.println("\nMapa após remover 'Maria': " + idades);
        
        int padrao = idades.getOrDefault("Ana", 0);
        System.out.println("Idade de Ana (padrao): " + padrao);
    }
}
