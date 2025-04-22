/*
Tarefa 18/03/2025
MODIFCADORES DE TIPOS:
private	  - Somente dentro da própria classe
protected - Dentro da classe e suas subclasses (herança)
public	  - Pode ser acessado de qualquer lugar (ex: no main)

* private - atributo saldo
- Ele é escondido da parte externa (como o main).
- Só pode ser manipulado por métodos públicos da própria classe (depositar, sacar, consultarSaldo).
- Isso protege contra alterações diretas indesejadas:
    cliente1.saldo = 999999; // ? Isso seria um risco se fosse public

* protected - atributo identificador
- Ele não pode ser acessado fora da classe (como no main).
- Mas pode ser acessado por classes que herdam ClienteBanco (se você fizesse herança futuramente).
- Bom pra manter o controle, mas permitir acesso controlado em classes filhas.

* public - atributos nome e numeroConta + métodos
- Podem ser acessados de qualquer lugar.
- Métodos depositar, sacar, consultarSaldo, exibirIdentificador são a interface pública da sua classe, 
ou seja, como o mundo externo interage com ela.

* Encapsulamento - o que é isso?
- Encapsular = esconder detalhes internos da classe, expondo só o necessário.
- Você esconde saldo (com private) e obriga o usuário a usar métodos como depositar() e consultarSaldo(). Isso evita erros e garante segurança.
- Exemplo de erro que seria possível se não usasse encapsulamento:
cliente1.saldo = -999; // Isso seria um problema sério!
*/

#include <iostream>
#include <string>

class ClienteBanco {
private:
    double saldo = 1000.0; // Atributo encapsulado (somente a própria classe pode acessar)

protected:
    int identificador; // Protegido: só a classe e suas herdeiras podem acessar

public:
    std::string nome;
    std::string numeroConta;

    // Método público: pode ser chamado no main
    void inicializarCliente(const std::string& nomeCliente, int idCliente, const std::string& conta) {
        nome = nomeCliente;
        identificador = idCliente;
        numeroConta = conta;
        std::cout << "Nome: " << nome
                  << " | Identificador: " << identificador
                  << " | Conta: " << conta << std::endl;
    }

    // Método público que acessa atributo privado indiretamente
    void depositar(double valor) {
        if (valor < 0) {
            std::cout << "Valor negativo! Deposite um valor maior do que 0.\n";
        } else {
            saldo += valor;
            std::cout << "Depósito de R$" << valor << " realizado com sucesso!\n";
        }
    }

    // Outro método público
    void sacar(double valor) {
        if (valor >= 0 && valor <= saldo) {
            saldo -= valor;
            std::cout << "Saque de R$" << valor << " realizado com sucesso!\n";
        } else {
            std::cout << "Saque inválido! Verifique o valor ou saldo insuficiente.\n";
        }
    }

    void consultarSaldo() {
        std::cout << "Saldo: R$" << saldo << std::endl;
    }

    void exibirIdentificador() const {
        std::cout << "Identificador: " << identificador << std::endl;
    }
};

int main() {
    ClienteBanco cliente1;

    cliente1.inicializarCliente("Lucas Eduardo", 123, "2910");

    cliente1.depositar(100.0);
    cliente1.sacar(50.0);
    cliente1.consultarSaldo();
    cliente1.exibirIdentificador();

    // cliente1.saldo = 5000;         ? Não pode acessar atributo privado
    // cliente1.identificador = 999; ? Não pode acessar atributo protected

    return 0;
}
