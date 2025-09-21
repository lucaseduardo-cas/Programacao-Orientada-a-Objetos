/* 
SET

Set é uma interface da Java Collections Framework que representa uma coleção
única:
- Não permite elementos duplicados - cada elemento é único
- Não mantém ordem específica (exceto implementações ordenadas)
- Implementações principais: HashSet, LinkedHashSet, TreeSet
- Baseado na matemática de conjuntos
- Operações de conjunto: união, interseção, diferença
- Não permite acesso por índice

Características:
- HashSet: melhor desempenho, sem ordem
- LinkedHashSet: mantém a ordem de inserção
- TreeSet: elementos ordenados naturalmente
- Operações de conjunto (união, interseção, diferença)
*/

// javac -d Classes ExemploSet2.java && java -cp Classes ExemploSet2
import java.util.HashSet;
import java.util.Set;

public class ExemploSet2 {
    public static void main(String[] args) {
        // Operações de conjunto
        Set<String> set1 = Set.of("A", "B", "C");
        Set<String> set2 = Set.of("B", "C", "D");

        // União
        Set<String> uniao = new HashSet<>(set1);
        uniao.addAll(set2);
        System.out.println("União: " + uniao);

        // Interseção
        Set<String> intersecao = new HashSet<>(set1);
        intersecao.retainAll(set2);
        System.out.println("Interseção: " + intersecao);
    }
}
