/*
Resolução Professor, aula 27/09/25
*/

import java.math.BigDecimal;

interface CalculaValorPagamento {
    BigDecimal calcularValor(int horaInicial, int horaFinal, BigDecimal valorHora);
}

// Implementação concreta do Strategy
class PagamentoPorHoraNormal implements CalculaValorPagamento {
    @Override
    public BigDecimal calcularValor(int horaInicial, int horaFinal, BigDecimal valorHora) {
        // Considerar hora inicial 8 o início do expediente, e hora final 18
        System.out.println("calculaValor na classe PagamentoPorHoraNormal");
        int horaInicialAux = Math.max(8, horaInicial);
        int horaFinalAux = Math.min(18, horaFinal);
        if (horaFinal <= horaInicial) {
            return BigDecimal.ZERO; // Não há horas válidas
        }
        return valorHora.multiply(new BigDecimal(horaFinalAux - horaInicialAux));
    }
}

class PagamentoPorHoraNormalEHoraExtra extends PagamentoPorHoraNormal {

    @Override
    public BigDecimal calcularValor(int horaInicial, int horaFinal, BigDecimal valorHora) {
        BigDecimal valorHoraNormal = super.calcularValor(horaInicial, horaFinal, valorHora);
        int horaExtraInicial = 8 - horaInicial;
        int horaExtraSaida = horaFinal - 18;
        int horasExtras = 0;
        if (horaExtraInicial > 0)
            horasExtras += horaExtraInicial;
        if (horaExtraSaida > 0)
            horasExtras += horaExtraSaida;
        BigDecimal valoExtra = valorHora.multiply(new BigDecimal(1.5*horasExtras));
        return valorHoraNormal.add(valoExtra);
    }
}

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

public class Aula2 {

    public static void main(String[] args) {
        Pagamento pagamento = new Pagamento(new PagamentoPorHoraNormalEHoraExtra());

        BigDecimal valorHora = new BigDecimal("50.00");
        BigDecimal valor = pagamento.calcularPagamento(9, 17, valorHora);
        System.out.println("Valor do pagamento funcionario - 1: R$  " + valor);

        valor = pagamento.calcularPagamento(7, 19, valorHora);
        System.out.println("Valor do pagamento funcionario - 2: R$  " + valor);
    }
}