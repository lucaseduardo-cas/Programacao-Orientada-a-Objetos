/*
Aula 29/04/2025

O que são funções virtuais?
Em C++, uma função virtual permite que o comportamento de um método seja sobrescrito por uma classe derivada e que, ao usar ponteiros ou referências da classe base, o método da classe derivada seja chamado corretamente.

Ou seja, é essencial para o polimorfismo em tempo de execução.

* Sintaxe básica:

class Animal {
public:
    virtual void fazerSom() {
        std::cout << "Animal faz som genérico" << std::endl;
    }
};

class Cachorro : public Animal {
public:
    void fazerSom() override {
        std::cout << "Cachorro late" << std::endl;
    }
};

* Com ou sem função virtual?

Animal* a = new Cachorro();
a->fazerSom();  // Vai chamar "Cachorro late" SÓ SE a função for virtual

Se a função não for virtual, o C++ chama a versão da classe base (Animal), mesmo que o objeto real seja um Cachorro.

Por que usar?
Para permitir sobrescrita real em tempo de execução

Para escrever código genérico com comportamento específico

Para aplicar polimorfismo verdadeiro com ponteiros/referências

* Dica visual:
Sem virtual	                                Com virtual
Chama método da classe base	        Chama método da classe derivada
Sem polimorfismo	                Polimorfismo ativado
*/

#include <iostream>
using namespace std;

class Animal {
public:
    virtual void som() {
        cout << "Som de animal genérico" << endl;
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
    a->som();  // Saída: Miau!
    delete a;
}
