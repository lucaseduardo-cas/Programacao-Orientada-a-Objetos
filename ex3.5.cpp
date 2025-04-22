/*
Tarefa 18/03/2025
Código com herança: ClienteVip acessando identificador
- Analogia rápida:
private = tranca o dado no cofre. Só o próprio dono (a classe) tem a chave.

protected = o dono e os filhos têm a chave.

public = tá em cima da mesa, qualquer um vê.
*/

#include <iostream>
#include <string>

// Classe base
class ClienteBanco {
private:
    double saldo = 1000.0; // privado: acesso só dentro da classe base

protected:
    int identificador; // protegido: acesso dentro da classe e das herdeiras

public:
    std::string nome;
    std::string numeroConta;

    void inicializarCliente(const std::string& nomeCliente, int idCliente, const std::string& conta) {
        nome = nomeCliente;
        identificador = idCliente;
        numeroConta = conta;
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    void sacar(double valor) {
        if (valor >= 0 && valor <= saldo) {
            saldo -= valor;
        }
    }

    double consultarSaldo() const {
        return saldo;
    }
};

/// Classe derivada
class ClienteVip : public ClienteBanco {
public:
    void mostrarDadosVip() {
        std::cout << "=== Cliente VIP ===\n";
        std::cout << "Nome: " << nome << std::endl;
        std::cout << "Conta: " << numeroConta << std::endl;
        std::cout << "Identificador (protegido): " << identificador << std::endl;
        std::cout << "Saldo: R$" << consultarSaldo() << std::endl;
    }
};

int main() {
    ClienteVip vip;
    vip.inicializarCliente("Lucas Eduardo", 999, "4444-8");

    // vip.identificador = 1234; ? Erro: identificador é protected, não pode ser acessado direto aqui
    vip.depositar(500);
    vip.sacar(300);
    
    vip.mostrarDadosVip(); // ? Aqui a classe derivada acessa os dados da base

    return 0;
}
