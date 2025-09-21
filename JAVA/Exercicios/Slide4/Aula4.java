/*
Exercício – Exceções personalizadas

Você deve criar uma exceção personalizada, como
EstoqueInsuficienteException , para tratar situações específicas no seu sistema
de gerenciamento de estoque.
Alterar o código da aula anterior para lançar e capturar essa exceção
personalizada quando a quantidade em estoque for insuficiente. 

    javac -d Classes Aula4.java && java -cp Classes Aula4
*/

class EstoqueInsuficienteException extends Exception {
    public EstoqueInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

class Produto {
    private String nome;
    private double custoUnitario;
    private int quantidade;

    public Produto() {
        this.nome = "";
        this.custoUnitario = 0;
        this.quantidade = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return 1.1 * custoUnitario;
    }

    public void adicionaItem(int qtd, double valorItem) {
        if (qtd > 0 && valorItem > 0) {
            double totalAtual = custoUnitario * quantidade;
            double totalNovo = valorItem * qtd;
            quantidade += qtd;
            custoUnitario = (totalAtual + totalNovo) / quantidade;
        }
    }

    public void removeItens(int qtd) throws EstoqueInsuficienteException {
        if (qtd > quantidade) {
            throw new EstoqueInsuficienteException("Estoque insuficiente");
        }
        quantidade -= qtd;
    }

    public String toString() {
        return "Produto: " + nome + 
               " quantidade em estoque: " + quantidade + 
               " custo: " + custoUnitario + 
               " preço: " + getPreco();
    }
}

public class Aula4 {
    public static void main(String[] args) {
        Produto produto1 = new Produto();
        produto1.setNome("Notebook Positivo");
        produto1.adicionaItem(10, 1000);
        System.out.println(produto1);
        try {
            produto1.removeItens(15);
        } catch (EstoqueInsuficienteException ex) {
            System.err.println("Você tentou retirar mais itens do que disponível no estoque");
        }
        System.out.println(produto1);
    }
}
