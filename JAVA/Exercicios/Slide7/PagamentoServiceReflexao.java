// javac -d Classes CalculaValorPagamento.java PagamentoServiceReflexao.java && java -cp Classes PagamentoServiceReflexao

import java.math.BigDecimal;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.Set;

// 2. IMPLEMENTAÇÕES CONCRETAS ANOTADAS (Requisito a)
// Marcadas com a anotação @Implementacao
@Implementacao(nome = "HORA_NORMAL")
class PagamentoPorHoraNormal implements CalculaValorPagamento {
    @Override
    public BigDecimal calcularValor (int horaInicial, int horaFinal, BigDecimal valorHora) {
        int horaInicialAux = Math.max(8, horaInicial);
        int horaFinalAux = Math.min(18, horaFinal);
        
        if (horaFinalAux <= horaInicialAux) { 
            return BigDecimal.ZERO; 
        }
        
        return valorHora.multiply(new BigDecimal(horaFinalAux - horaInicialAux));
    }
}

@Implementacao(nome = "HORA_EXTRA")
class PagamentoComHoraExtra implements CalculaValorPagamento {
    // Simula cálculo com 50% a mais
    @Override
    public BigDecimal calcularValor (int horaInicial, int horaFinal, BigDecimal valorHora) {
        int horas = horaFinal - horaInicial;
        BigDecimal valorBase = valorHora.multiply(new BigDecimal(horas));
        return valorBase.multiply(new BigDecimal("1.50")); 
    }
}


public class PagamentoServiceReflexao {

    /**
     * Simula a busca e instanciação de uma classe concreta
     * com base no seu nome, usando Reflexão. (Requisito b e c)
     * * @param nomeImplementacao O nome da implementação (@Implementacao(nome="..."))
     * @return Uma instância da classe concreta da estratégia.
     * @throws Exception Se a classe não for encontrada ou não puder ser instanciada.
     */
    private static CalculaValorPagamento encontrarEInstanciarEstrategia(String nomeImplementacao) throws Exception {
        
        // Simulação da busca de todas as classes anotadas (Substitui a biblioteca Reflections)
        // Em um projeto real, 'Reflections' faria isso automaticamente.
        // Aqui, nós verificamos as classes que sabemos que existem.
        Class<?>[] classesDisponiveis = {PagamentoPorHoraNormal.class, PagamentoComHoraExtra.class};

        for (Class<?> clazz : classesDisponiveis) {
            // Verifica se a classe possui a anotação @Implementacao
            if (clazz.isAnnotationPresent(Implementacao.class)) {
                // Obtém a anotação
                Implementacao anotacao = clazz.getAnnotation(Implementacao.class);
                
                // Verifica se o nome na anotação corresponde ao nome desejado
                if (anotacao.nome().equals(nomeImplementacao)) {
                    System.out.println("-> Classe encontrada via Anotação: " + clazz.getSimpleName());
                    
                    // INSTANCIAÇÃO DINÂMICA (Requisito c)
                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                    
                    // Cria e retorna uma nova instância da implementação concreta.
                    return (CalculaValorPagamento) constructor.newInstance();
                }
            }
        }
        throw new ClassNotFoundException("Implementação '" + nomeImplementacao + "' não encontrada ou não anotada corretamente.");
    }


    public static void main (String[] args) {
        // Objeto Cliente do Padrão Strategy
        CalculaValorPagamento estrategiaPagamento = null;
        BigDecimal valorHora = new BigDecimal("50.00");
        
        try {
            // 1. USO DE REFLEXÃO PARA ESCOLHER A ESTRATÉGIA (HORA_NORMAL)
            estrategiaPagamento = encontrarEInstanciarEstrategia("HORA_NORMAL");
            
            // Simulação de uso do Contexto (Pagamento)
            // Calculando 9h às 17h (8 horas)
            BigDecimal valor1 = estrategiaPagamento.calcularValor(9, 17, valorHora);
            System.out.println("Valor Pagamento HORA_NORMAL (9h-17h): R$ " + valor1);
            
            System.out.println("---------------------------------");
            
            // 2. USO DE REFLEXÃO PARA ESCOLHER A ESTRATÉGIA (HORA_EXTRA)
            estrategiaPagamento = encontrarEInstanciarEstrategia("HORA_EXTRA");
            
            // Calculando 9h às 12h (3 horas) com hora extra (50% a mais)
            BigDecimal valor2 = estrategiaPagamento.calcularValor(9, 12, valorHora);
            System.out.println("Valor Pagamento HORA_EXTRA (9h-12h): R$ " + valor2);


        } catch (Exception e) {
            System.err.println("Erro Crítico no Sistema de Pagamento por Reflexão: " + e.getMessage());
            e.printStackTrace();
        }
    }
}