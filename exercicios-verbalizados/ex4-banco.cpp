/*
Definir uma classe para representar o cliente de um banco. Pelo menos 4 atributos e 4 métodos.
25/03/2025: (banco), tem que ter o saldo e identificador do cliente e o identificador não pode ser o nome do cliente. 
Não é pra usar o "construtor" e também definir no mínimo 4 métodos para manipular os atributos de cada cliente. Ex.: 
método saque, tem que trabalhar saldo e subtrair e parâmetro que estou passando. Se estou criando um depósito tem que somar.
*/

#include <iostream>
#include <string>

class Banco {
private:
	int identificador; // ID do cliente
	double saldo;

public:
	// Método para definir o identificador (já que não pode usar o construtor)
	void definirIdentificador(int id) {
		identificador = id;
	}

	// Método para definir o saldo inicial
	void definirSaldo(double valor) {
		saldo = valor;
	}

	// Método para depositar dinheiro
	void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			std::cout << "Depósito de R$ " << valor << " realizado com sucesso.\n";
		} else {
			std::cout << "Valor inválido para depÃ³sito!\n";
		}
	}

	// Método para sacar dinheiro
	void sacar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			std::cout << "Saque de R$ " << valor << " realizado com sucesso.\n";
		} else {
			std::cout << "Saldo insuficiente ou valor inválido!\n";
		}
	}

	// Método para exibir saldo
	void exibirSaldo() const {
		std::cout << "Saldo atual: R$ " << saldo  << "\n";
	}
};

int main () {
	Banco cliente;
	int id;
	double saldoInicial;

	std::cout << "Digite o identificador do cliente: ";
	std::cin >> id;
	cliente.definirIdentificador(id);

	std::cout << "Digite o saldo inicial: R$ ";
	std::cin >> saldoInicial;
	cliente.definirSaldo(saldoInicial);

	cliente.exibirSaldo();

	cliente.depositar(500);
	cliente.exibirSaldo();

	cliente.sacar(200);
	cliente.exibirSaldo();

	return 0;

}
