import java.math.BigDecimal;

public class TesteTrinca extends Servico {
    private final String metodo;

    public TesteTrinca(BigDecimal maoDeObra, String metodo) {
        super("Teste de trinca", maoDeObra);
        this.metodo = metodo;
    }

    @Override
    public BigDecimal calcularCusto() {
        return baseMaoDeObra;
    }

    @Override
    public int calcularPrazoHoras() {
        return 2;
    }

    @Override
    public String gerarLaudo(Veiculo v) {
        return super.gerarLaudo(v) + String.format("\n- Método: %s; nenhuma trinca detectada.", metodo);
    }
}