import java.math.BigDecimal;

// public class PlainaCabecote extends Servico {
class PlainaCabecote extends Servico {
    private final int mmRemovidos;

    public PlainaCabecote(BigDecimal maoDeObra, int mmRemovidos) {
        super("Plaina de cabeçote", maoDeObra);
        this.mmRemovidos = mmRemovidos;
    }

    @Override
    public BigDecimal calcularCusto() {
        // custo adicional por mm removido
        BigDecimal adicional = new BigDecimal(mmRemovidos).multiply(new BigDecimal("25.00"));
        return baseMaoDeObra.add(adicional);
    }

    @Override
    public int calcularPrazoHoras() {
        return 6;
    }

    @Override
    public String gerarLaudo(Veiculo v) {
        return super.gerarLaudo(v) + String.format("\n- Remoção: %dmm; dentro de tolerâncias.", mmRemovidos);
    }
}