/* 
Melhorar a classe Produto:

– Implementar uma ordenação natural para a classe Produto (pelo nome do produto).
– Implementar uma ordenação personalizada para a classe Produto (pela quantidade em estoque).
– Criar uma lista de produtos, adicionar alguns produtos e ordenar usando ambas as ordenações.
*/

// javac -d Classes Aula5.java && java -cp Classes Aula5
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Exceção personalizada para estoque
class EstoqueInsuficienteException extends Exception {
    public EstoqueInsuficienteException(String message) {
        super(message);
    }
}

class Produto implements Comparable<Produto> {
    private String nome;
    private double custoUnitario;
    private int quantidade;

    // Construtor que inicializa todos os atributos com validação
    public Produto(String nome, double custoUnitario, int quantidade) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            this.nome = "Nome Indisponível";
        }
        this.custoUnitario = Math.max(0, custoUnitario);
        this.quantidade = Math.max(0, quantidade);
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        }
    }

    public double getCustoUnitario(){
        return custoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco(){
        return 1.1 * custoUnitario;
    }

    public void adicionaItem(int quantidadeAdicionada, double valorItem){
        if (quantidadeAdicionada > 0 && valorItem >= 0) {
            double novoCustoTotal = (this.custoUnitario * this.quantidade) + (valorItem * quantidadeAdicionada);
            int novaQuantidadeTotal = this.quantidade + quantidadeAdicionada;
            
            this.custoUnitario = novoCustoTotal / novaQuantidadeTotal;
            this.quantidade = novaQuantidadeTotal;
        }
    }

    public void removeItens(int quantidadeRemovida) throws EstoqueInsuficienteException {
        if (quantidadeRemovida > this.quantidade) {
            throw new EstoqueInsuficienteException("Estoque insuficiente. Disponível: " + this.quantidade);
        }
        this.quantidade -= quantidadeRemovida;
    }

    @Override
    public String toString(){
        return "Produto: " + nome + " | quantidade em estoque: " + quantidade + " | custo: R$" + String.format("%.2f", custoUnitario) + " | preco: R$" + String.format("%.2f", getPreco());
    }

    // Implementação da ordenação natural (por nome)
    @Override
    public int compareTo(Produto outro) {
        return this.nome.compareTo(outro.nome);
    }
}


public class Aula5 {
    public static void main(String[] args) {
        // Criando a lista de produtos
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", 1500, 5));
        produtos.add(new Produto("Mouse", 50, 20));
        produtos.add(new Produto("Teclado", 120, 10));

        System.out.println("--- Lista original de produtos ---");
        for (Produto p : produtos) {
            System.out.println(p);
        }

        // Ordenação natural (por nome)
        Collections.sort(produtos);
        System.out.println("\n--- Lista ordenada por nome (natural) ---");
        for (Produto p : produtos) {
            System.out.println(p);
        }

        // Ordenação personalizada (por quantidade em estoque)
        produtos.sort(new Comparator<Produto>() {
            @Override
            public int compare(Produto p1, Produto p2) {
                return Integer.compare(p1.getQuantidade(), p2.getQuantidade());
            }
        });
        System.out.println("\n--- Lista ordenada por quantidade em estoque ---");
        for (Produto p : produtos) {
            System.out.println(p);
        }
        
        // Testando a exceção
        Produto produto1 = new Produto("Notebook", 1000, 10);
        System.out.println("\nEstado inicial do produto1: " + produto1);
        try {
            produto1.removeItens(15);
        } catch (EstoqueInsuficienteException ex) {
            System.err.println("Você tentou retirar mais itens do que disponivel no estoque: " + ex.getMessage());
        }
        System.out.println("Estado final do produto1: " + produto1);
    }
}