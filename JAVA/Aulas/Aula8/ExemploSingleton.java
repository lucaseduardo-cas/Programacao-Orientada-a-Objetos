/* 

javac -d Classes ExemploSingleton.java && java -cp Classes ExemploSingleton
*/

// Padrão Singleton: Garante que haja apenas uma instância da classe.
class Configuracao {
    // 1. Variável estática e privada que armazena a única instância.
    private static Configuracao instancia; 

    // Atributos de configuração
    private int alturaJanela;
    private int larguraJanela;
    private String tema;

    // 2. Construtor padrão privado (para evitar instanciação externa)
    private Configuracao() {
        // Inicializa as configurações padrão
        tema = "Tema Padrão";
        alturaJanela = 600;
        larguraJanela = 800;
    }

    // 3. Método estático público que fornece o ponto de acesso global.
    public static Configuracao getInstancia() {
        // Checa se a instância ainda não foi criada
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }

    // Getters e Setters para mostrar que a mesma instância mantém o estado
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}

public class ExemploSingleton {
    public static void main(String[] args) {
        System.out.println("--- Padrão Singleton ---");

        // 1. Obtendo a primeira instância
        Configuracao config1 = Configuracao.getInstancia();
        System.out.println("Config1 (Tema Inicial): " + config1.getTema());

        // 2. Modificando o estado da primeira instância
        config1.setTema("Tema Escuro Personalizado");
        System.out.println("Config1 (Tema Modificado): " + config1.getTema());
        
        // 3. Obtendo a segunda instância (deve ser a mesma)
        Configuracao config2 = Configuracao.getInstancia();
        
        System.out.println("\nConfig2 (Tema Atual): " + config2.getTema());
        
        // Verificando se as referências são iguais
        System.out.println("\nConfig1 e Config2 são o mesmo objeto? " + (config1 == config2)); 
    }
}
