/*
Conversão de tipo

- Uma classe, ao herdar de outra, assume o
tipo dessa onde quer que seja necessário
- Upcasting
    - Conversão para uma classe mais genérica
- Downcasting
    - Conversão para uma classe mais específica

* Upcasting
- Ocorre no sentido Subclasse → Superclasse
- Não há necessidade de indicação explícita
- A classe derivada sempre vai manter as
características públicas da superclasse
    Contexto de classe = <subClasse (atributos, métodos) <super_Classe (atributos, métodos)>>

* Downcasting Conversão
    - Ocorre no sentido Superclasse → Subclasse
    - Não é feito de forma automática!
    - Deve-se deixar explícito, informando o
    nome do subtipo antes do nome da variável
    - Isso sempre será válido?
        - Não! Por que?
        - Subclasse → Características específicas

    - Nem sempre uma superclasse poderá
    assumir o tipo de uma subclasse
        - Exemplo: Todo Gato é Animal, mas nem todo
    Animal é Gato, pode ser Cachorro ou Pato
    - Verificação: dynamic_cast
    - Exceção: bad_cast
*/

// Exemplo 1
#include <iostream>
#include <typeinfo>

class Base {
public:
    virtual void dummy() {};
};

class Derived_A : public Base { };

class Derived_B : public Base { };

int main() {
    Base* b1 = new Derived_A();
    Base* b2 = new Base();

    if (Derived_A* d1 = dynamic_cast<Derived_A*>(b1)) {
        std::cout << "Essa chamada eh valida!" << std::endl;
    } else {
        std::cout << "Essa chamada NAO eh valida!" << std::endl;
    }

    if (Derived_A* d2 = dynamic_cast<Derived_A*>(b2)) {
        std::cout << "Essa chamada eh valida!" << std::endl;
    } else {
        std::cout << "Essa chamada NAO eh valida!" << std::endl;
    }

    if (Derived_B* d3 = dynamic_cast<Derived_B*>(b1)) {
        std::cout << "Essa chamada eh valida!" << std::endl;
    } else {
        std::cout << "Essa chamada NAO eh valida!" << std::endl;
    }

    delete b1;
    delete b2;

    return 0;
}
