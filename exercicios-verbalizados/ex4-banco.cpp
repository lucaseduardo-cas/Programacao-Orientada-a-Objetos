
#include <iostream>
#include <string>

class Banco {
private:
	int identificador; // ID do cliente (não é nome)
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
			std::cout << "Valor inválido para depósito!\n";
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
