/* 
    Polimorfismo e o Padrão de Projeto Strategy

    Polimorfismo permite que diferentes classes implementem o mesmo método de
    maneiras distintas. O padrão Strategy utiliza esse conceito para definir uma
    família de algoritmos, encapsulando cada um e tornando-os intercambiáveis.
        - Permite que o algoritmo varie independentemente dos clientes que o
          utilizam.
        - Facilita a extensibilidade - novos algoritmos podem ser adicionados sem
          alterar o código existente.
        - Baseado no princípio "programar para interfaces, não para
          implementações".
*/

// Interface Strategy
import java.math.BigDecimal;

// Interface Strategy
interface CalculaValorPagamento {
    BigDecimal calcularValor(int horaInicial, int horaFinal, BigDecimal valorHora);
}

// Implementação concreta do Strategy
class PagamentoPorHoraNormal implements CalculaValorPagamento {
    @Override
    public BigDecimal calcularValor(int horaInicial, int horaFinal, BigDecimal valorHora) {
        // Considerar hora inicial 8 o início do expediente e hora final 18
        int horaInicialAux = Math.max(8, horaInicial);
        int horaFinalAux = Math.min(18, horaFinal);
        if (horaFinalAux <= horaInicialAux) { // Lógica ajustada para ser mais robusta
            return BigDecimal.ZERO; // Não há horas válidas
        }
        return valorHora.multiply(new BigDecimal(horaFinalAux - horaInicialAux));
    }
}

public class Pagamento {
    // A classe Pagamento utiliza a estratégia sem conhecer os detalhes
    private CalculaValorPagamento estrategia;

    public Pagamento(CalculaValorPagamento estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(CalculaValorPagamento estrategia) {
        this.estrategia = estrategia;
    }

    public BigDecimal calcularPagamento(int horaInicial, int horaFinal, BigDecimal valorHora) {
        return estrategia.calcularValor(horaInicial, horaFinal, valorHora);
    }
    
    public static void main(String[] args) {
        Pagamento pagamento = new Pagamento(new PagamentoPorHoraNormal());
        BigDecimal valorHora = new BigDecimal("50.00");
        BigDecimal valor = pagamento.calcularPagamento(9, 17, valorHora);
        System.out.println("Valor do pagamento: R$ " + valor);
    }
}
