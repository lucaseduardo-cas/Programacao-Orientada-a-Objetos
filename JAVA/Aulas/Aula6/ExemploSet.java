/* 
Coleções em Orientação a Objetos

Coleções são estruturas de dados que armazenam múltiplos elementos, as coelções agrupam objetos de forma:
    - Adicionar
    - Remover
    - Tamanho
    - Iterar
*/

import java.util.*;

    public class ExemploSet {
    public static void main(String[] args) {
    // Operações de conjunto
        Set<String> set1 = Set.of("A", "B", "C");
        Set<String> set2 = Set.of("B", "C", "D");

        Set<String> uniao = new HashSet<>(set1);
        uniao.addAll(set2); // União

        Set<String> intersecao = new HashSet<>(set1);
        intersecao.retainAll(set2); // Interseção

        System.out.println("União: " + uniao);
        System.out.println("Interseção: " + intersecao);
    }
}