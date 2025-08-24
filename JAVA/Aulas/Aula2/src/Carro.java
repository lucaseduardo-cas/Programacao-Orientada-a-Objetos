public class Carro extends Veiculo {
    private final int portas;

    public Carro(String placa, String marca, String modelo, String combustivel, int portas) {
        super(placa, marca, modelo, combustivel);
        this.portas = portas;
    }
}