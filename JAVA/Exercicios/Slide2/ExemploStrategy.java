/* 
Exercício prático
Implemente uma nova estratégia de pagamento que calcule o valor
considerando horas extras (acima de 8 horas diárias).
A estratégia deve aplicar um fator de multiplicação (ex: 1.5) para horas extras.
Crie uma classe de teste que utilize a nova estratégia e verifique o cálculo
correto. 
*/

// Comando para compilar e executar o código
// javac -d Classes ExemploStrategy.java && java -cp Classes ExemploStrategy

import java.math.BigDecimal;
import java.math.RoundingMode;

// Interface Strategy
interface CalculaValorPagamento {
    BigDecimal calcularValor(int horaInicial, int horaFinal, BigDecimal valorHora);
}

// Implementação concreta do Strategy (PagamentoPorHoraNormal)
class PagamentoPorHoraNormal implements CalculaValorPagamento {
    @Override
    public BigDecimal calcularValor(int horaInicial, int horaFinal, BigDecimal valorHora) {
        int horaInicialAux = Math.max(8, horaInicial);
        int horaFinalAux = Math.min(18, horaFinal);
        if (horaFinalAux <= horaInicialAux) {
            return BigDecimal.ZERO;
        }
        int horasValidas = horaFinalAux - horaInicialAux;
        return valorHora.multiply(new BigDecimal(horasValidas));
    }
}

// Implementação da nova estratégia de pagamento para horas extras
class PagamentoComHorasExtras implements CalculaValorPagamento {
    private final static int HORAS_NORMAIS_DIARIAS = 8;
    private final static BigDecimal FATOR_HORA_EXTRA = new BigDecimal("1.5");

    @Override
    public BigDecimal calcularValor(int horaInicial, int horaFinal, BigDecimal valorHora) {
        int horasTrabalhadas = horaFinal - horaInicial;
        BigDecimal valorTotal;

        if (horasTrabalhadas <= HORAS_NORMAIS_DIARIAS) {
            // Se nao houver horas extras, o calculo é simples
            valorTotal = valorHora.multiply(new BigDecimal(horasTrabalhadas));
        } else {
            // Calculo para horas normais
            int horasNormais = HORAS_NORMAIS_DIARIAS;
            BigDecimal valorHorasNormais = valorHora.multiply(new BigDecimal(horasNormais));

            // Calculo para horas extras
            int horasExtras = horasTrabalhadas - HORAS_NORMAIS_DIARIAS;
            BigDecimal valorHorasExtras = valorHora.multiply(FATOR_HORA_EXTRA).multiply(new BigDecimal(horasExtras));

            valorTotal = valorHorasNormais.add(valorHorasExtras);
        }

        // Arredonda o valor para duas casas decimais
        return valorTotal.setScale(2, RoundingMode.HALF_UP);
    }
}


// Classe Context que usa o Strategy
class Pagamento {
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
}

// Classe de teste que utiliza a nova estratégia (Teste da Strategy)
public class ExemploStrategy {

    public static void main(String[] args) {
        // Testando a estratégia de pagamento normal
        Pagamento pagamento = new Pagamento(new PagamentoPorHoraNormal());
        BigDecimal valorHora = new BigDecimal("50.00");
        BigDecimal valor = pagamento.calcularPagamento(9, 17, valorHora);
        System.out.println("Valor do pagamento (normal): R$ " + valor); // 8 horas

        // Testando a nova estratégia de pagamento com horas extras
        pagamento.setEstrategia(new PagamentoComHorasExtras());
        BigDecimal valorComExtra = pagamento.calcularPagamento(9, 20, valorHora); // 11 horas
        System.out.println("Valor do pagamento (com extra): R$ " + valorComExtra);
    }
}