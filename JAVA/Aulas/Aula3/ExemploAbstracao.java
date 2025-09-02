/* 
ABSTRAÇÃO DE DADOS

Abstração de dados é o processo de simplificação que:
    - Foca nos aspectos essenciais de um objeto, ignorando detalhes irrelevantes
    - Define tipos de dados abstratos que especificam operações sem revelar
      implementação
    - Estabelece contratos através de interfaces e classes abstratas
    - Separa "o que fazer" do "como fazer" 

    Elementos principais:
    - Classes abstratas e interfaces
    - Métodos abstratos que definem comportamento
    - Implementações concretas específicas
    - Polimorfismo através de abstrações

    Exemplo prático - Abstração de dados

    javac -d Classes ExemploAbstracao.java && java -cp Classes ExemploAbstracao
*/
// Abstração de uma estrutura de dados Lista
abstract class Lista<T> {
    protected int tamanho;

    public abstract void adicionar(T elemento);
    public abstract T remover(int indice);
    public abstract T obter(int indice);

    // Método concreto comum a todas as implementações
    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }
}

// Exemplo prático - Implementação de abstração
// Implementação concreta
class ListaArray<T> extends Lista<T> {
    private T[] elementos;
    private static final int CAPACIDADE_INICIAL = 10;

    @SuppressWarnings("unchecked")
    public ListaArray() {
        elementos = (T[]) new Object[CAPACIDADE_INICIAL];
        tamanho = 0;
    }

    @Override
    public void adicionar(T elemento) {
        // Lógica para redimensionar o array se necessário (não incluída no exemplo original)
        if (tamanho == elementos.length) {
           // Dobrar a capacidade do array, por exemplo.
           // Esta lógica é importante para uma implementação real.
        }
        elementos[tamanho++] = elemento;
    }

    @Override
    public T obter(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites: " + indice);
        }
        return elementos[indice];
    }

    @Override
    public T remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice fora dos limites: " + indice);
        }
        T elemento = elementos[indice];
        // Lógica de remoção... (deslocar elementos para a esquerda)
        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i+1];
        }
        tamanho--;
        return elemento;
    }
}


// Classe principal para execução
public class ExemploAbstracao {

    // Método principal para demonstrar o uso da Lista
    public static void main(String[] args) {
        Lista<String> minhaLista = new ListaArray<>();

        System.out.println("Lista criada. Vazia? " + minhaLista.estaVazia());

        minhaLista.adicionar("Elemento A");
        minhaLista.adicionar("Elemento B");
        minhaLista.adicionar("Elemento C");

        System.out.println("Tamanho após adições: " + minhaLista.getTamanho());
        System.out.println("Item na posição 1: " + minhaLista.obter(1));

        String removido = minhaLista.remover(0);
        System.out.println("Item removido: " + removido);
        
        System.out.println("Tamanho final: " + minhaLista.getTamanho());
        System.out.println("Item restante na posição 0: " + minhaLista.obter(0));
    }
}