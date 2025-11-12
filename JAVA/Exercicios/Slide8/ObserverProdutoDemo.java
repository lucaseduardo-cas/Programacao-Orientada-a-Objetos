// javac -d Classes ObserverProdutoDemo.java && java -cp Classes ObserverProdutoDemo

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

// 1. INTERFACE OBSERVER (Observador)
// Define o contrato para objetos que querem ser notificados.
interface ProdutoObserver {
    // Passamos o Produto e o preço antigo para que o observador possa calcular a variação
    void atualizar(Produto produto, double precoAntigo);
}

// 2. CLASSE OBSERVER CONCRETA (Interessado)
// Reage à mudança de preço.
class MonitorPreco implements ProdutoObserver {
    private String nomeMonitor;
    private static final DecimalFormat df = new DecimalFormat("R$ #,##0.00");

    public MonitorPreco(String nomeMonitor) {
        this.nomeMonitor = nomeMonitor;
    }

    @Override
    public void atualizar(Produto produto, double precoAntigo) {
        double novoPreco = produto.getPreco();
        if (novoPreco != precoAntigo) {
            System.out.println(">>> NOTIFICAÇÃO (" + nomeMonitor + ") <<<");
            System.out.println("  Produto: " + produto.getNome());
            System.out.println("  Preço Antigo: " + df.format(precoAntigo));
            System.out.println("  Preço Novo:   " + df.format(novoPreco));
            System.out.println("  Variação: " + df.format(novoPreco - precoAntigo));
        }
    }
}

// 3. CLASSE SUBJECT (Observável) - PRODUTO
// Mantém a lista de observadores e notifica quando o estado muda.
class Produto {
    private String nome;
    private double custoUnitario;
    private int quantidade;
    
    // Lista de observadores
    private List<ProdutoObserver> observadores = new ArrayList<>();

    // Construtor
    public Produto(String nome) {
        this.nome = nome;
    }

    // --- Métodos de Gestão do Observer ---
    public void adicionarObservador(ProdutoObserver o) {
        observadores.add(o);
    }

    public void removerObservador(ProdutoObserver o) {
        observadores.remove(o);
    }
    
    // Dispara a notificação
    private void notificarObservadores(double precoAntigo) {
        for (ProdutoObserver o : observadores) {
            o.atualizar(this, precoAntigo);
        }
    }

    // --- Métodos de Estado ---
    
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
        // Preço de venda (10% de markup sobre o custo)
        return 1.1 * custoUnitario;
    }

    // Método que altera o estado e notifica os observadores
    public void adicionaItem(int quantidadeAdicionada, double valorItem){
        double precoAntigo = getPreco(); // Preço antes da atualização
        
        // Lógica de ATUALIZAÇÃO DO CUSTO MÉDIO PONDERADO
        double custoTotalAntigo = this.custoUnitario * this.quantidade;
        double custoTotalNovoItem = valorItem * quantidadeAdicionada;
        int quantidadeTotal = this.quantidade + quantidadeAdicionada;

        this.quantidade = quantidadeTotal;
        
        if (quantidadeTotal > 0) {
             this.custoUnitario = (custoTotalAntigo + custoTotalNovoItem) / quantidadeTotal;
        } else {
             this.custoUnitario = 0;
        }
       
        // DISPARO DO OBSERVER: Notifica após a mudança de estado (preço)
        notificarObservadores(precoAntigo);
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        return "Produto: " + nome + 
               " | Quantidade: " + quantidade + 
               " | Custo Médio: " + df.format(custoUnitario) +
               " | Preço Venda: " + df.format(getPreco());
    }
}

// 4. CLASSE CLIENTE/DEMOSTRATIVA (Antiga Aula3)
public class ObserverProdutoDemo {

    public static void main(String[] args) {
        // 1. Cria o Produto (Subject)
        Produto produto1 = new Produto("Notebook Positivo");

        // 2. Cria e anexa os Observadores
        MonitorPreco monitorEstoque = new MonitorPreco("Estoque");
        MonitorPreco monitorVendas = new MonitorPreco("Vendas");

        produto1.adicionarObservador(monitorEstoque);
        produto1.adicionarObservador(monitorVendas);
ls
        System.out.println("\n--- ESTADO INICIAL ---");
        System.out.println(produto1);

        // AÇÃO 1: Primeira adição (Muda o preço de R$0.00 para R$1100.00)
        System.out.println("\n--- AÇÃO 1: Adicionar 10 itens por R$1000 ---");
        produto1.adicionaItem(10, 1000); // NOTIFICAÇÃO 1

        // AÇÃO 2: Segunda adição (Muda o preço de R$1100.00 para R$916.67)
        System.out.println("\n--- AÇÃO 2: Adicionar 5 itens por R$500 ---");
        produto1.adicionaItem(5, 500); // NOTIFICAÇÃO 2
        
        System.out.println("\n--- ESTADO FINAL ---");
        System.out.println(produto1);
    }
}