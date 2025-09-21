/*
- Iterable

raiz da hierarquia de
coleções, permite iteração sobre
elementos.
Todo objeto que implementa
Iterable pode ser percorrido com
um iterator ou por um for-each
loop.

Exemplo:
    Interable<Elemento> it = ...;
    for (Elemento e : it) {
        // usar
    }
*/

// javac -d Classes ExemploIterable.java && java -cp Classes ExemploIterable
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ExemploIterable {
    public static void main(String[] args) {
        // Criando uma coleção (ArrayList) que implementa Iterable
        List<String> frutas = new ArrayList<>();
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Morango");

        // Loop for-each, que funciona porque a List é Iterable
        System.out.println("Iterando com for-each:");
        for (String fruta : frutas) {
            System.out.println(fruta);
        }

        // Usando um Iterator explicitamente
        System.out.println("\nIterando com Iterator:");
        Iterator<String> it = frutas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
