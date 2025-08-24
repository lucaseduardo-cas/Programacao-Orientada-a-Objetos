import java.math.BigDecimal;

public class RetificaCompleta extends Servico implements Tributavel {
    private final BigDecimal pecas;

    public RetificaCompleta(BigDecimal maoDeObra, BigDecimal pecas) {
        super("Retífica completa", maoDeObra);
        this.pecas = pecas;
    }

    @Override
    public BigDecimal calcularCusto() {
        return baseMaoDeObra.add(pecas);
    }

    @Override
    public int calcularPrazoHoras() {
        return 24; // estimativa
    }

    @Override
    public BigDecimal getImposto() {
        // imposto somente sobre mão de obra neste exemplo (8.5%)
        return baseMaoDeObra.multiply(new BigDecimal("0.085"));
    }

    @Override
    public String gerarLaudo(Veiculo v) {
        return super.gerarLaudo(v) + "\n- Processo: desmontagem, medição, usinagem total, montagem e testes.";
    }
}