/*
Tarefa POO - item 1 - Defina exemplos de associações com diferentes cardinaldiades. 
Ou seja, 1:1, 1:N, N:N. Fazer o código em C++ e o diagrama de classes representando 
suas associações.

1:1 - Um CPF pertence a uma única Pessoa, e cada Pessoa tem um único CPF.

Pessoa ---------1:1--------- CPF
+ nome                       + numero
+ cpf: CPF                   + getNumero()

*/

#include <iostream>
using namespace std;

class CPF {
private:
    string numero;
public:
    CPF(string numero) : numero(numero) {}
    string getNumero() const { return numero; }
};

class Pessoa {
private:
    string nome;
    CPF cpf;
public:
    Pessoa(string nome, CPF cpf) : nome(nome), cpf(cpf) {}

    void mostrarDados() {
        cout << "Pessoa: " << nome << ", CPF: " << cpf.getNumero() << endl;
    }
};

int main() {
    CPF cpf("000.000.000-00");
    Pessoa pessoa("João", cpf);
    pessoa.mostrarDados();

    return 0;
}
