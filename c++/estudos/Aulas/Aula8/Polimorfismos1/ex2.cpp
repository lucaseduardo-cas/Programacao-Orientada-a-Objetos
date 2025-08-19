/*
Polimorfismo
*/

#include <iostream>
using namespace std;

class Animal {
public:
    virtual void fale () {};
};

class Gato : public Animal {
public:
    void fale() override {
        cout << "Miau" << endl;
    }
};

class Cachorro : public Animal {
public:
    void fale() override {
        cout << "Au! Au!" << endl;
    }
};

int main() {
    Animal* c = new Cachorro(); // “c” e “g” são Animais que se comportam como Cachorro/Gato
    c->fale();

    Animal* g = new Gato();
    c->fale();

    delete c;
    delete g;

    return 0;
}
