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
    Cachorro c;
    c.fale();

    Gato g;
    g.fale();

    return 0;
}
