/*
Aula 29/04/2025

O que s�o fun��es virtuais?
Em C++, uma fun��o virtual permite que o comportamento de um m�todo seja sobrescrito por uma classe derivada e que, ao usar ponteiros ou refer�ncias da classe base, o m�todo da classe derivada seja chamado corretamente.

Ou seja, � essencial para o polimorfismo em tempo de execu��o.

* Sintaxe b�sica:

class Animal {
public:
    virtual void fazerSom() {
        std::cout << "Animal faz som gen�rico" << std::endl;
    }
};

class Cachorro : public Animal {
public:
    void fazerSom() override {
        std::cout << "Cachorro late" << std::endl;
    }
};

* Com ou sem fun��o virtual?

Animal* a = new Cachorro();
a->fazerSom();  // Vai chamar "Cachorro late" S� SE a fun��o for virtual

Se a fun��o n�o for virtual, o C++ chama a vers�o da classe base (Animal), mesmo que o objeto real seja um Cachorro.

Por que usar?
Para permitir sobrescrita real em tempo de execu��o

Para escrever c�digo gen�rico com comportamento espec�fico

Para aplicar polimorfismo verdadeiro com ponteiros/refer�ncias

* Dica visual:
Sem virtual	                                Com virtual
Chama m�todo da classe base	        Chama m�todo da classe derivada
Sem polimorfismo	                Polimorfismo ativado
*/

#include <iostream>
using namespace std;

class Animal {
public:
    virtual void som() {
        cout << "Som de animal gen�rico" << endl;
    }
};

class Gato : public Animal {
public:
    void som() override {
        cout << "Miau!" << endl;
    }
};

int main() {
    Animal* a = new Gato();
    a->som();  // Sa�da: Miau!
    delete a;
}
