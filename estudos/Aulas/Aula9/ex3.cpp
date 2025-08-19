/*
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
    // Função virtual com parâmetro vazio
    virtual void som() {
        cout << "Animal faz som genérico" << endl;
    }

    // Função virtual com sobrecarga (com string)
    virtual void som(const string& nome) {
        cout << nome << " faz um som indefinido" << endl;
    }

    virtual ~Animal() = default; // Boa prática
};

// Classe derivada
class Cachorro : public Animal {
public:
    // Sobrescreve a função sem parâmetro
    void som() override {
        cout << "Cachorro: Au Au!" << endl;
    }

    // Sobrescreve a função com string (sobrecarga de virtual)
    void som(const string& nome) override {
        cout << nome << " está latindo!" << endl;
    }
};

int main() {
    // Ponteiro da classe base apontando para objeto derivado
    Animal* a = new Cachorro();

    // Polimorfismo em ação — chama a versão da classe derivada
    a->som();             // Saída: Cachorro: Au Au!
    a->som("Rex");        // Saída: Rex está latindo!

    // Também funciona com objeto direto
    Cachorro c;
    c.som("Bolt");        // Saída: Bolt está latindo!

    delete a;
    return 0;
}
