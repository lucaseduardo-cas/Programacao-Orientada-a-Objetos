// Exemplo 2

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
    A a;
    B b;
    a = b; // Apenas a parte relativa a A de ‘b’ é copiada em ‘a’.
    a.f();

    return 0;
}
