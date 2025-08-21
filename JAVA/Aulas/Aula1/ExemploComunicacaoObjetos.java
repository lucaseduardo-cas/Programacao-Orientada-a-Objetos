/* 
MENSAGEM E INTERAÇÃO

Conteúdo teórico detalhado sobre Mensagens e Interação.
Definições: Mensagens são chamadas de métodos entre objetos que
permitem a comunicação e colaboração. A interação representa como objetos
trabalham juntos para realizar tarefas complexas, trocando informações e
coordenando ações.
Exemplos práticos
Diagramas UML quando aplicável
*/

// Classe Cliente
class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    // Enviar mensagem
    public void fazerPedido(Restaurante restaurante, String prato) {
        System.out.println(nome + " fazendo pedido...");
        restaurante.receberPedido(this, prato);
    }

    // Receber mensagem
    public void receberConfirmacao(String msg) {
        System.out.println(nome + " recebeu: " + msg);
    }

    public String getNome() {
        return nome;
    }
}

// Classe Restaurante
class Restaurante {
    public void receberPedido(Cliente cliente, String prato) {
        System.out.println("Pedido recebido: " + prato);
        // Responde ao cliente
        cliente.receberConfirmacao("Pedido confirmado!");
    }
}

public class ExemploComunicacaoObjetos {

    public static void main(String[] args) {
        // Criando os objetos
        Cliente cliente = new Cliente("Lucas");
        Restaurante restaurante = new Restaurante();

        // Demonstrando a comunicacao
        cliente.fazerPedido(restaurante, "Pizza de Calabresa");
    }
}