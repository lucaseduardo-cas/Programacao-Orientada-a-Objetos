public class Moto extends Veiculo {
    private final int cilindradaCc;

    public Moto(String placa, String marca, String modelo, String combustivel, int cilindradaCc) {
        super(placa, marca, modelo, combustivel);
        this.cilindradaCc = cilindradaCc;
    }
}