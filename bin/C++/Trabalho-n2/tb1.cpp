/*
Padrão escolhido: Singleton

/*
Padrão escolhido: Singleton

Justificativa da escolha:
    O padrão Singleton é ideal quando se deseja garantir que apenas uma instância de uma classe exista
    — muito comum em sistemas de configuração global, acesso a banco de dados, geradores de log, etc.

Observações:
    - Esta implementação é thread-safe graças ao uso da variável estática local,
      que é inicializada na primeira chamada ao método getInstancia().
    - Não há necessidade de gerenciar a memória manualmente (sem new/delete),
      pois o objeto é destruído automaticamente ao final do programa.
    - Esta é a forma recomendada para implementar Singleton em C++11 e versões posteriores.
*/

#include <iostream>
using namespace std;

// Classe Singleton: Logger
// Garante que a classe Logger tenha apenas uma instância e fornece um ponto de acesso global a ela.
class Logger {
private:
    Logger() {} // Construtor privado: impede criação externa.
    Logger(const Logger&) = delete; // Proíbe cópia.
    void operator=(const Logger&) = delete; // Proíbe atribuição.

public:
    // Método de acesso à instância única.
    // A variável estática local é inicializada apenas uma vez (thread-safe em C++11+).
    static Logger& getInstancia() {
        static Logger instancia; // Instância única e thread-safe
        return instancia;
    }

    // Simula o registro de uma mensagem no console.
    void log(const string& msg) {
        cout << "[LOG]: " << msg << endl;
    }
};

// Função principal onde o padrão Singleton é demonstrado.
int main() {
    Logger& logger1 = Logger::getInstancia(); // Obtém a instância do Logger.
    logger1.log("Sistema iniciado."); // Usa a instância para registrar uma mensagem.

    Logger& logger2 = Logger::getInstancia(); // Obtém a mesma instância novamente.
    logger2.log("Ação executada."); // Registra outra mensagem.

    // Confirma que ambas as referências referenciam a mesma instância.
    if (&logger1 == &logger2)
        cout << "Ambos referenciam a mesma instância." << endl;

    return 0;
}
