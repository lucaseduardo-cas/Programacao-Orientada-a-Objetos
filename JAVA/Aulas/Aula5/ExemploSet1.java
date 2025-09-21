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

// javac -d Classes ExemploSet1.java && java -cp Classes ExemploSet1
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet1 {
    public static void main(String[] args) {
        // Adicionando (duplicatas ignoradas)
        Set<String> cores = new HashSet<>();
        cores.add("Azul");
        cores.add("Vermelho");
        cores.add("Azul"); // Será ignorado

        System.out.println("Cores unicas: " + cores.size());
        System.out.println(cores);

        // TreeSet mantém ordem
        Set<String> ordenadas = new TreeSet<>();
        ordenadas.addAll(cores);
        System.out.println("Cores ordenadas: " + ordenadas);
    }
}
