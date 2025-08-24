public abstract class Veiculo {
    private final String placa, marca, modelo, combustivel;

    protected Veiculo(String placa, String marca, String modelo, String combustivel) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.combustivel = combustivel;
    }

    public String getDescricao() {
        return String.format("%s %s (%s) %s", marca, modelo, placa, combustivel);
    }
}