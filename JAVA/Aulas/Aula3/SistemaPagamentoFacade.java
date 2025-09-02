/*
 * Padrão de Projeto: Façade
 
 * O padrão Façade é uma abordagem para fornecer uma interface simplificada e
 * unificada para um conjunto de interfaces em um subsistema. Ele oculta a
 * complexidade do sistema e facilita a interação com ele.
 *
 * A implementação envolve a criação de uma classe que encapsula as
 * interações com várias classes ou subsistemas, fornecendo métodos
 * simplificados para os clientes.
 
 javac -d Classes SistemaPagamentoFacade.java && java -cp Classes SistemaPagamentoFacade
 */

// --- Subsistema Complexo (Classes que a Façade irá simplificar) ---

class ProcessadorCartaoCredito {
    public boolean validarCartao(String numeroCartao) {
        System.out.println("1. Validando o cartão: " + numeroCartao);
        return numeroCartao != null && numeroCartao.length() > 10;
    }

    public void efetuarPagamento(String numeroCartao, double valor) {
        System.out.println("2. Efetuando pagamento de R$" + valor + " no cartão " + numeroCartao);
    }
}

class ServicoPagamentoOnline {
    // Outra classe complexa do sistema
}

class GerenciadorFaturas {
    // Mais uma classe complexa do sistema
}


// --- Implementação da Façade ---

public class SistemaPagamentoFacade {
    private ProcessadorCartaoCredito processadorCartao;
    private ServicoPagamentoOnline servicoPagamento;
    private GerenciadorFaturas gerenciadorFaturas;

    public SistemaPagamentoFacade() {
        this.processadorCartao = new ProcessadorCartaoCredito();
        this.servicoPagamento = new ServicoPagamentoOnline();
        this.gerenciadorFaturas = new GerenciadorFaturas();
    }

    // Métodos simplificados para os clientes
    public boolean processarPagamentoCartao(String numeroCartao, double valor) {
        if (processadorCartao.validarCartao(numeroCartao)) {
            processadorCartao.efetuarPagamento(numeroCartao, valor);
            return true;
        }
        return false;
    }
    
    // --- Ponto de Entrada para Execução (main) ---
    public static void main(String[] args) {
        // O cliente (neste caso, o próprio método main) interage com a Façade.
        SistemaPagamentoFacade pagamentoFacade = new SistemaPagamentoFacade();

        System.out.println("Iniciando processo de pagamento...");
        
        // O cliente chama um único método para uma operação complexa.
        boolean sucesso = pagamentoFacade.processarPagamentoCartao("1234-5678-9012-3456", 250.99);

        if (sucesso) {
            System.out.println("\nPagamento processado com sucesso!");
        } else {
            System.out.println("\nFalha ao processar o pagamento.");
        }
    }
}