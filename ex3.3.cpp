/*
44- Tarefa 25/03/2025: Definir uma classe para representar o cliente de um banco. Pelo menos 4
atributos e 4 métodos.
(banco), tem que ter o saldo e identificador do cliente e o identificador não pode ser o nome do cliente.
Não é pra usar o "construtor" e também definir no mínimo 4 métodos para manipular os atributos de cada
cliente. Ex.: 
método saque, tem que trabalhar saldo e subtrair e parâmetro que estou passando. Se estou criando um
depósito tem que somar.

---------------------------------------------------------------------------------------------------------------------------------------
Tarefa: Classe ClienteBanco

Definir uma classe em C++ chamada ClienteBanco para representar um cliente de um banco. Esta classe deve possuir:

- Atributos (mínimo 4):
Saldo: Representa o saldo da conta do cliente.
Identificador do Cliente: Um valor único para identificar o cliente. Importante: Este identificador não pode ser o mesmo que o nome do cliente.
Nome do Cliente: O nome completo do cliente.
Número da Conta: O número da conta bancária do cliente.

- Métodos (mínimo 4 para manipular os atributos):
depositar(double valor): Recebe um valor como parâmetro e adiciona esse valor ao saldo do cliente. Valide se o valor do depósito é positivo.
sacar(double valor): Recebe um valor como parâmetro e subtrai esse valor do saldo do cliente. Realize as seguintes validações:
O valor do saque deve ser positivo.
Deve haver saldo suficiente para realizar o saque.
consultarSaldo(): Exibe o saldo atual do cliente.
exibirIdentificador(): Exibe o identificador único do cliente.
Restrição:

Não utilize um construtor com parâmetros para inicializar os atributos da classe diretamente na declaração. Você pode usar um método separado para essa finalidade ou inicializar os atributos de outra forma.
*/

#include <iostream>
#include <string>

class ClienteBanco {
public:
    double saldo=1000.0;
    int identificador;
    std::string nome;
    std::string numeroConta;

    void depositar(double valor) {
        if (valor < 0) {
            std::cout <<"Valor negativo! Deposite um valor maior do que 0: " << std::endl;
        } else {
            saldo += valor;
            std::cout <<"Depósito de R$" << valor << " realizado com sucesso!" << std::endl;
        }
    }

    void sacar(double valor) {
        if (valor >= 0 && valor <= saldo) {
            saldo -= valor;
            std::cout <<"Saque de R$" << valor << " realizado com sucesso!" << std::endl;
        } else if (valor < 0) {
            std::cout <<"Valor negativo! Saque um valor maior do que 0: " << std::endl;
        }
    }

    void consultarSaldo() {
        std::cout <<"Saldo: R$" << saldo << std::endl;
    }

    void exibirIdentificador() const {
        std::cout <<"Identificador: " << identificador << std::endl;
    }

    void inicializarCliente(const std::string& nomeCliente, int idCliente, const std::string& conta) {
        nome = nomeCliente;
        identificador = idCliente;
        numeroConta = conta;
        std::cout <<"Nome: " << nome << " | Identificador: " << identificador << " | Conta: " << conta << std::endl;
    }
};

int main () {

    ClienteBanco cliente1;
    cliente1.inicializarCliente("Lucas Eduardo", 123, "2910");
    cliente1.depositar(100.0);
    cliente1.sacar(50.0);
    cliente1.consultarSaldo();
    cliente1.exibirIdentificador();

    return 0;
}
