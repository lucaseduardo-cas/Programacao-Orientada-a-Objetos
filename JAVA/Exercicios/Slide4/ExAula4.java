/*
Exercício – Exceções personalizadas

Você deve criar uma exceção personalizada, como
EstoqueInsuficienteException , para tratar situações específicas no seu sistema
de gerenciamento de estoque.
Alterar o código da aula anterior para lançar e capturar essa exceção
personalizada quando a quantidade em estoque for insuficiente. 
 */

class EstoqueInsuficienteException extends Exception {

}

class Produto {
    private String nome;
    private double custoUnitario;
    private int quantidade;

    public Produto(){

    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
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

    public void adicionaItem(int quantidade, double valorItem){
        //ATUALIZAR AS QUANTIDADES E O CUSTO;
    }

    public void removeItens(int quantidade) throws EstoqueInsuficienteException{
        Produto produto = null;
        produto = new Produto();

        if(this.quantidade < quantidade){
            throw new EstoqueInsuficienteException();
        }
    }

    public String toString(){
        return "Produto: " + nome + " quantidade em estoque: " + quantidade + " custo: " + custoUnitario;
    }

}



public class ExAula4 {

    public static void main(String[] args) {
        Produto produto1 = new Produto();
        produto1.setNome("Notebook Positivo");
        produto1.adicionaItem(10, 1000);
        System.out.println(produto1);
        try {
            produto1.removeItens(15);
        } catch (EstoqueInsuficienteException ex) {
            System.err.println("Você tentou retirar mais itens do que disponivel no estoque");
        }
        System.err.println(produto1);
    }
    
}