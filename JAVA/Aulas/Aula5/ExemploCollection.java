/* 
Collection

Estende Iterable,
representa um grupo de objetos
(elementos).
Define operações básicas como
adicionar, remover, verificar
tamanho e limpar a coleção.
 
    Collection<Elemento> colecao = ...;
    colecao.add(new Elemento());
    colecao.remove(new Elemento());
    int tamanho = colecao.size();
    colecao.clear();
*/

import java.util.ArrayList;
import java.util.Collection;

// Collection: estende Iterable, representa um grupo de objetos
// (elementos).
// Define operações básicas como adicionar, remover, verificar
// tamanho e limpar a coleção.
class ExemploCollection {

    public static void main(String[] args) {
        // Criação de uma Collection com ArrayList
        Collection<String> nomes = new ArrayList<>();

        System.out.println("A coleção está vazia? " + nomes.isEmpty());

        nomes.add("João");
        nomes.add("Maria");
        nomes.add("Pedro");

        System.out.println("Tamanho da coleção: " + nomes.size());
        System.out.println("Elementos na coleção: " + nomes);

        nomes.remove("Maria");
        System.out.println("Tamanho após remover 'Maria': " + nomes.size());
        System.out.println("Elementos na coleção: " + nomes);

        nomes.clear();
        System.out.println("Tamanho após limpar a coleção: " + nomes.size());
        System.out.println("A coleção está vazia? " + nomes.isEmpty());
    }
}
