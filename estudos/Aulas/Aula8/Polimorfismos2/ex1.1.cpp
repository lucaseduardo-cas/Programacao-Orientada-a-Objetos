/*
Introdução
- Polimorfismo Estático
    - Tempo de compilação
    - Ligação Prematura (Early/Static binding)
    - Mesmo contexto → Sobrecarga
- Polimorfismo Dinâmico
    - Tempo de execução
    - Ligação Tardia (Late/Dynamic binding)
    -Hierarquia → Sobrescrita

- Polimorfismo Estático
    - Geralmente considerado mais eficiente
- Polimorfismo Dinâmico
    - Apresenta uma flexibilidade maior
- Como combinar os dois tipos?
    - Será que pode haver algum problema?
    - Quais cuidados devem ser tomados?
*/

// Exemplo 1
#include <iostream>
#include <cmath>
#include <string>

using namespace std;

class A {
public:
    virtual void f() {
        cout << "A::f()" << endl;
    }
};

class B : public A {
public:
    void f() override {
        cout << "B::f()" << endl;
    }
};

int main() {
    A *pa = new B();
    pa->f();

    return 0;
}
