
/*
Exercício – Boas práticas de encapsulamento

Você precisará criar um cadastro de produtos para um sistema de inventário. Para isso, implemente a classe `Produto` seguindo as boas práticas de encapsulamento discutidas:
- Atributos privados: nome, custo unitário, quantidade.
- Construtor que inicializa todos os atributos com validação.
- Getters para todos os atributos, setter para nome.
- Um metódo adicionarItem que recebe valor (quantidade e valor).
- Um método especifico para remover estoque (quantidade).
- O custo unitário deve ser calculado conforme a média ponderada dos itens em estoque.
- O preço deve ser 10% maior que o custo de unidade.
*/

class Produto {
    private String nome;
    private double custoUnitario;
    private int quantidade;

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

    public String toString(){
        return "Produto: " + nome + " quantidade em estoque: " + quantidade + " custo: " + custoUnitario;
    }
}

public class Aula3 {
    public static void main(String[] args) {
        Produto produto1 = new Produto();
        produto1.setNome("Notebook Positivo");
        produto1.adicionaItem(10, 1000);
        System.out.println(produto1);
        produto1.adicionaItem(5, 500);
        System.err.println(produto1);
    }
}