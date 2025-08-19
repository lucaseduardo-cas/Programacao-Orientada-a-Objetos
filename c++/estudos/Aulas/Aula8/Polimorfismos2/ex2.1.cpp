/*
Static vs. Dynamic Dispatch

- Method Dispatch
    - Como uma linguagem seleciona qual
implementação de um método ou função usar
    - Static Dispatch (compilação)
- Há uma garantia de que há apenas uma única
    implementação do método em questão
- Dynamic Dispatch (execução)
    - Adiar a seleção da implementação apropriada
    até que o runtime type seja conhecido

Virtual Method Table (vtable)
  - Sempre que uma classe define um método virtual, o compilador adiciona
    uma variável de membro oculto à classe que aponta para uma matriz de
    ponteiros para funções (virtuais) chamada de tabela de método virtual.
*/

#include <iostream>
#include <cmath>
#include <string>

using namespace std;

class Base {
public:
    virtual void function1() {};
    virtual void function2() {};
};

class D1: public Base {
public:
    void function1() override {};
};

class D2: public Base {
public:
    void function2() override {};
};

class ClasseBase {
public:
    ClasseBase() {
        cout << "BASE Constructor..." << endl;
    }
    ~ClasseBase() {
        cout << "BASE Destructor..." << endl;
    }
};

class ClasseDerivada : public ClasseBase {
public:
    ClasseDerivada() {
        cout << "DERIVADA Constructor..." << endl;
    }
    ~ClasseDerivada() {
        cout << "DERIVADA Destructor..." << endl;
    }
};

int method() {
    ClasseDerivada d;
    return 0; // Adicionado retorno para a função method()
}

int main() {
    method();
    cout << "-----------" << endl;
    ClasseBase *b = new ClasseDerivada();
    delete b;
    return 0;
}
