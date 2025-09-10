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


  javac -d Classes Produto.java && java -cp Classes Produto
*/

class Produto {
    private String nome;
    private double custoUnitario;
    private int quantidade;

    public Produto(String nome, int quantidade, double valorItem) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            this.nome = "Sem nome";
        }
        if (quantidade > 0 && valorItem > 0) {
            this.quantidade = quantidade;
            this.custoUnitario = valorItem;
        } else {
            this.quantidade = 0;
            this.custoUnitario = 0;
        }
    }

    public Produto() {
        this("Sem nome", 0, 0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return custoUnitario * 1.1;
    }

    public void adicionaItem(int qtd, double valorItem) {
        if (qtd > 0 && valorItem > 0) {
            double valorTotalEstoque = custoUnitario * quantidade;
            double valorNovo = valorItem * qtd;
            quantidade += qtd;
            custoUnitario = (valorTotalEstoque + valorNovo) / quantidade;
        }
    }

    public void removerItem(int qtd) {
        if (qtd > 0 && qtd <= quantidade) {
            quantidade -= qtd;
        }
    }

    public String toString() {
        return "Produto: " + nome + 
               " | Quantidade: " + quantidade + 
               " | Custo: " + custoUnitario + 
               " | Preço: " + getPreco();
    }
}

public class Aula3 {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Notebook Positivo", 10, 1000);
        System.out.println(produto1);
        produto1.adicionaItem(5, 500);
        System.out.println(produto1);
        produto1.removerItem(3);
        System.out.println(produto1);
    }
}
