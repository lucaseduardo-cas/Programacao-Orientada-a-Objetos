/*
Tarefa POO: Trazer exemplos em C++ que utiliza o mecanismo de exceções.

1. exemplo básico (que nem o do quadro);
*/

#include <iostream>
using namespace std;

int main() {
    try {
        int divisor = 0;
        if (divisor == 0) {
            throw "Divisão por zero não é permitida!";
        }
        cout << 10 / divisor << endl;
    } catch (const char* erro) {
        cout << "Erro: " << erro << endl;
    }

    return 0;
}
