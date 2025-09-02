/* 
OCULTAÇÃO DE INFORMAÇÕES

Ocultação de informações (Information Hiding) é um princípio que estabelece:
    - Esconder detalhes de implementação que não são relevantes para o
      usuário da classe
    - Expor apenas interfaces necessárias para interação com o objeto
    - Proteger dados sensíveis evitando acesso direto
    - Facilitar mudanças internas sem afetar código cliente 

    Características:
    - Uso de modificadores de acesso (private, protected, public)
    - Métodos de acesso controlado
    - Validação de dados na entrada
    - Abstração de complexidade interna

    Exemplo prático - Ocultação de Informações

    javac -d Classes Funcionario.java && java -cp Classes Funcionario
*/
public class Funcionario {

    private String nome;
    private double salario; // Informação sensível - oculta
    private String cpf; // Informação sensível - oculta

    public Funcionario(String nome, double salario, String cpf) {
        this.nome = nome;
        this.salario = salario;
        this.cpf = cpf;
    }

    // Acesso público apenas ao necessário
    public String getNome() {
        return nome;
    }

    // Método que não expõe informação sensível diretamente
    public boolean temSalarioSuperiorA(double valor) {
        return salario > valor;
    }

    // CPF mascarado para proteção
    public String getCpfMascarado() {
        return "***." + cpf.substring(3, 6) + "." + "***-**";
    }

    public static void main(String[] args) {
        // Criando um funcionário com dados sensíveis
        Funcionario func = new Funcionario("João da Silva", 5500.00, "12345678901");

        // Exibindo apenas as informações permitidas ou mascaradas
        System.out.println("Nome do funcionário: " + func.getNome());
        System.out.println("CPF mascarado: " + func.getCpfMascarado());

        // Verificando uma condição sem expor o salário diretamente
        double valorDeCorte = 5000.00;
        if (func.temSalarioSuperiorA(valorDeCorte)) {
            System.out.println("O salário é superior a R$" + valorDeCorte);
        } else {
            System.out.println("O salário não é superior a R$" + valorDeCorte);
        }
    }
}
