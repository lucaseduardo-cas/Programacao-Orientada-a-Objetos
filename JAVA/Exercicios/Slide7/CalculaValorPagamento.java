// javac -d Classes CalculaValorPagamento.java PagamentoServiceReflexao.java && java -cp Classes PagamentoServiceReflexao

import java.math.BigDecimal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 1. ANOTAÇÃO PERSONALIZADA (Requisito a)
// @Retention(RetentionPolicy.RUNTIME) é essencial para que a anotação possa ser lida pela Reflexão em tempo de execução.
@Retention(RetentionPolicy.RUNTIME)
@interface Implementacao {
    String nome(); // Adiciona um atributo para identificar a estratégia
}

// INTERFACE DA ESTRATÉGIA
public interface CalculaValorPagamento {
    BigDecimal calcularValor (int horaInicial, int horaFinal, BigDecimal valorHora);
}