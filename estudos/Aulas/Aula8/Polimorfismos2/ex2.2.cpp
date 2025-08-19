/*
Static vs. Dynamic Dispatch
Destrutores virtuais

- Destrutor da classe base deve ser virtual
quando for usada de maneira polimórfica
    - Desalocar um objeto do tipo derivado por meio
    de um ponteiro para seu tipo base
    - Ocorre um static dispatch se não for virtual
- Tipo estático vs. Tipo dinâmico
    - Tipo da variável declarada (contrato/referência)
    - Tipo do objeto na memória (comportamento)

    // Exemplo 3
*/

#include <iostream>

using namespace std;

class A {

};

class B : public A {

};

class C {
  public:
    void m(A a) {
      cout << "C::m(A)" << endl;
    }

    void m(B b) {
      cout << "C::m(B)" << endl;
    }
};

int main() {

  A* ta = new A();
  A* tab = new B();

  C c;
  c.m(*ta);
  c.m(*tab);

  return 0;
}
