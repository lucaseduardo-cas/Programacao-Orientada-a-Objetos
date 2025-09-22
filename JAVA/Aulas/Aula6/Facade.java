// Interfaces ou classes "escondidas" pelo Facade
class ProcessadorCartaoCredito {
    public boolean validarCartao(String numeroCartao) {
        System.out.println("Validando cartão de crédito: " + numeroCartao);
        return true; // Simula a validação
    }
}

class ServicoPagamentoOnline {
    public boolean efetuarPagamento(String numeroCartao, double valor) {
        System.out.println("Efetuando pagamento online no valor de: " + valor);
        return true; // Simula o pagamento
    }
}

class GerenciadorFaturas {
    public void gerarFatura() {
        System.out.println("Gerando fatura do pagamento...");
    }
}

// Exemplo classe Slide 6 - Encapsulamento e o Padrão de Projeto Façade:
//      Encapsulamento oculta a complexidade de um sistema, expondo apenas uma interface simplificada.
//      O padrão Façade aplica esse princípio ao fornecer uma interface unificada para um conjunto de 
//      interfaces em um subsistema, facilitando o uso do sistema.

class SistemaPagamentoFacade {
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
            return servicoPagamento.efetuarPagamento(numeroCartao, valor);
        }
        return false;
    }
}

public class Facade {
    public static void main(String[] args) {
        // O cliente (main) usa a Fachada para processar o pagamento
        // sem precisar interagir com as classes de baixo nível.
        SistemaPagamentoFacade facade = new SistemaPagamentoFacade();
        boolean sucesso = facade.processarPagamentoCartao("1234-5678-9012-3456", 150.75);

        if (sucesso) {
            System.out.println("Pagamento processado com sucesso!");
        } else {
            System.out.println("Falha ao processar o pagamento.");
        }
    }
}