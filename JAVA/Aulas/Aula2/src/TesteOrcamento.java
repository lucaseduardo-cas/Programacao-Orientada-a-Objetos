import java.math.BigDecimal;

public class TesteOrcamento {
    public static void main(String[] args) {
        var carro = new Carro("ABC-1234", "GM", "Onix 1.0", "Flex", 4);
        var orc = new Orcamento(carro);

        orc.adicionar(new RetificaCompleta(new BigDecimal("1500.00"), new BigDecimal("820.00")));
        orc.adicionar(new PlainaCabecote(new BigDecimal("300.00"), 2));
        orc.adicionar(new TesteTrinca(new BigDecimal("180.00"), "Líquido penetrante"));

        System.out.println("Custo total: R$ " + orc.totalCusto());
        System.out.println("Prazo total (h): " + orc.prazoTotalHoras());
        System.out.println("Impostos: R$ " + orc.totalImpostos());
        System.out.println(orc.laudos());
    }
}