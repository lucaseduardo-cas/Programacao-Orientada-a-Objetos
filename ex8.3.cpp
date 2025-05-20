/*
Aula 13/05/2025

g++ -g -o poo4 poo4.cpp
gdb ./poo4
break main
run
next
print (variavel)
gdb info variables

Trazer um exemplo do uso de sobrecarga de m�todo de fun��o virtual (ou de m�todo virtual), ou seja, de sobrescrito.
*/

#include <iostream>
using namespace std;

// Classe base
class Animal {
public:
    // Fun��o virtual ? pode ser sobrescrita
    virtual void som() {
        cout << "Animal faz som genérico" << endl;
    }

    // Fun��o com sobrecarga ? par�metros diferentes
    void som(string nome) {
        cout << nome << " faz um som indefinido" << endl;
    }
};

// Classe derivada
class Cachorro : public Animal {
public:
    // Sobrescreve a fun��o virtual
    void som() override {
        cout << "Cachorro: Au Au!" << endl;
    }

    // Sobrecarga na classe derivada tamb�m
    void som(string nome) {
        cout << nome << " está latindo!" << endl;
    }
};

int main() {
    // Polimorfismo: ponteiro da base aponta para objeto da derivada
    Animal* a = new Cachorro();

    // Vai chamar o m�todo da classe derivada por ser virtual
    a->som(); // Sa�da: Cachorro: Au Au!

    // Chama a vers�o com argumento string ? n�o � virtual!
    // E como estamos usando ponteiro de Animal, chama o m�todo da classe base
    a->som("Rex"); // Sa�da: Rex faz um som indefinido

    // Para chamar a sobrecarga da derivada, precisa do tipo derivado
    Cachorro c;
    c.som("Bolt"); // Sa�da: Bolt est� latindo!

    delete a;
    return 0;
}
