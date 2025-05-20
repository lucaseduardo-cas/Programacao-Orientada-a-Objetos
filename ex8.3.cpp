Ã¯Â»Â¿/*
Aula 13/05/2025

g++ -g -o poo4 poo4.cpp
gdb ./poo4
break main
run
next
print (variavel)
gdb info variables

Trazer um exemplo do uso de sobrecarga de método de função virtual (ou de método virtual), ou seja, de sobrescrito.
*/

#include <iostream>
using namespace std;

// Classe base
class Animal {
public:
    // Função virtual — pode ser sobrescrita
    virtual void som() {
        cout << "Animal faz som genérico" << endl;
    }

    // Função com sobrecarga — parâmetros diferentes
    void som(string nome) {
        cout << nome << " faz um som indefinido" << endl;
    }
};

// Classe derivada
class Cachorro : public Animal {
public:
    // Sobrescreve a função virtual
    void som() override {
        cout << "Cachorro: Au Au!" << endl;
    }

    // Sobrecarga na classe derivada também
    void som(string nome) {
        cout << nome << " está latindo!" << endl;
    }
};

int main() {
    // Polimorfismo: ponteiro da base aponta para objeto da derivada
    Animal* a = new Cachorro();

    // Vai chamar o método da classe derivada por ser virtual
    a->som(); // Saída: Cachorro: Au Au!

    // Chama a versão com argumento string — não é virtual!
    // E como estamos usando ponteiro de Animal, chama o método da classe base
    a->som("Rex"); // Saída: Rex faz um som indefinido

    // Para chamar a sobrecarga da derivada, precisa do tipo derivado
    Cachorro c;
    c.som("Bolt"); // Saída: Bolt está latindo!

    delete a;
    return 0;
}
