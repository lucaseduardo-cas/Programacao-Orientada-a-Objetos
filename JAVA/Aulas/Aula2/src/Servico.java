import java.math.BigDecimal;

public abstract class Servico {
    protected final String nome;
    protected final BigDecimal baseMaoDeObra;

    protected Servico(String nome, BigDecimal baseMaoDeObra) {
        this.nome = nome;
        this.baseMaoDeObra = baseMaoDeObra;
    }

    public abstract BigDecimal calcularCusto();
    public abstract int calcularPrazoHoras();

    public String gerarLaudo(Veiculo v) {
        return String.format("Laudo do serviço '%s' para %s", nome, v.getDescricao());
    }

    public String getNome() { return nome; }
}