/*
 * Exemplo prático – Boas práticas de encapsulamento
 *
 * Este código demonstra os princípios de um bom encapsulamento,
 * conforme apresentado no slide. As diretrizes incluem:
 * - Manter atributos privados.
 * - Validar dados nos setters e construtores.
 * - Implementar métodos de negócio (comportamentais).
 * - Expor apenas o necessário para garantir um estado consistente.
 * 
    javac -d Classes ExemploEncapsulamento.java && java -cp Classes ExemploEncapsulamento
 */

import java.time.LocalDate;

// Exemplo prático de encapsulamento
class Produto {
    // 1. Atributos privados
    private String nome;
    private double preco;
    private int quantidade;
    private LocalDate dataVencimento;

    // 2. Construtor com validação para garantir estado válido
    public Produto(String nome, double preco, int quantidade, LocalDate dataVencimento) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setDataVencimento(dataVencimento);
    }

    // 3. Getters simples
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }
    public LocalDate getDataVencimento() { return dataVencimento; }

    // 4. Setters com validação
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome.trim();
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        if (dataVencimento != null && dataVencimento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data de vencimento não pode ser no passado");
        }
        this.dataVencimento = dataVencimento;
    }

    // 5. Métodos comportamentais
    public boolean estaVencido() {
        if (this.dataVencimento == null) {
            return false; // Produtos sem data de vencimento não vencem
        }
        return this.dataVencimento.isBefore(LocalDate.now());
    }

    public double calcularValorTotal() {
        return this.preco * this.quantidade;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade a adicionar deve ser positiva");
        }
        this.quantidade += quantidade;
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade <= 0 || quantidade > this.quantidade) {
            // Não é possível remover 0, um valor negativo, ou mais do que existe
            return false;
        }
        this.quantidade -= quantidade;
        return true;
    }
}


// --- Classe Principal para Execução ---
public class ExemploEncapsulamento {

    public static void main(String[] args) {
        System.out.println("--- Demonstração de Encapsulamento ---");

        // Criando um produto com dados válidos amanhã
        LocalDate dataDeAmanha = LocalDate.now().plusDays(1);
        Produto produto = new Produto("Leite Integral", 4.50, 20, dataDeAmanha);
        
        System.out.println("Produto criado: " + produto.getNome());
        System.out.println("Valor total em estoque: R$ " + produto.calcularValorTotal());
        System.out.println("Produto está vencido? " + produto.estaVencido());

        // Usando um método comportamental para alterar o estado
        produto.adicionarEstoque(10);
        System.out.println("Quantidade após adicionar 10 unidades: " + produto.getQuantidade());

        // Demonstração da validação em um setter
        try {
            System.out.println("\nTentando criar um produto com quantidade negativa...");
            // A variável é removida, pois o objeto não será usado
            new Produto("Suco", 7.0, -5, dataDeAmanha); 
        } catch (IllegalArgumentException e) {
            // A exceção é esperada por causa da validação
            System.out.println("SUCESSO: Capturamos o erro esperado -> " + e.getMessage());
        }
    }
}