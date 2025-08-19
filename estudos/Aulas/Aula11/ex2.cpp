/*
Tarefa POO: Trazer exemplos em C++ que utiliza o mecanismo de exceções.

2. exemplo com múltiplos blocos try;
*/

#include <iostream>
using namespace std;

int main() {
    try {
        throw 10;
    } catch (int e) {
        cout << "Pegou um inteiro: " << e << endl;
    }

    try {
        throw string("Erro como string");
    } catch (string e) {
        cout << "Pegou uma string: " << e << endl;
    }

    return 0;
}
