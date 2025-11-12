/*
Tarefa POO: Trazer exemplos em C++ que utiliza o mecanismo de exceções.

3. exemplo com exceções dentro de classes ou usando classes como referência
*/

#include <iostream>
#include <stdexcept> // Para std::runtime_error
using namespace std;

class ContaBancaria {
private:
    double saldo;

public:
    ContaBancaria(double saldoInicial) : saldo(saldoInicial) {}

    void sacar(double valor) {
        if (valor > saldo) {
            throw runtime_error("Saldo insuficiente!");
        }
        saldo -= valor;
    }

    void exibirSaldo() {
        cout << "Saldo atual: R$" << saldo << endl;
    }
};

int main() {
    ContaBancaria conta(100.0);

    try {
        conta.sacar(150.0);
    } catch (runtime_error& e) {
        cout << "Exceção: " << e.what() << endl;
    }

    conta.exibirSaldo();
    return 0;
}
