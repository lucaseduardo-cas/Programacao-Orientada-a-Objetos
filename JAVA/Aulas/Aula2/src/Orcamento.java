import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orcamento {
    private final Veiculo veiculo;
    private final List<Servico> itens = new ArrayList<>();

    public Orcamento(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void adicionar(Servico s) {
        itens.add(s);
    }

    public BigDecimal totalCusto() {
        return itens.stream()
                .map(Servico::calcularCusto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int prazoTotalHoras() {
        return itens.stream()
                .mapToInt(Servico::calcularPrazoHoras)
                .sum();
    }

    public BigDecimal totalImpostos() {
        return itens.stream()
                .filter(s -> s instanceof Tributavel)
                .map(s -> ((Tributavel) s).getImposto())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String laudos() {
        StringBuilder sb = new StringBuilder("LAUDOS PARA: " + veiculo.getDescricao() + "\n");
        for (Servico s : itens) {
            sb.append("\n---").append(s.getNome()).append("---\n");
            sb.append(s.gerarLaudo(veiculo)).append("\n");
        }
        return sb.toString();
    }
}