/*
* UNIVERSO INCLUSÃO

- Modela subtipos e herança
    - Redefinição em classes descendentes
    - O subtipo está incluído no próprio tipo
- Onde um objeto de um determinado tipo
for esperado, um do subtipo deve ser aceito
    - Princípio da Substituição de Liskov
    - O contrário nem sempre é válido!
*/

#include <iostream>
#include <list>
using namespace std;

class Animal {
public:
    virtual void fale() = 0;
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
    list<Animal*> lista;

    for(int i=0; i<5;i++) {
        if (i % 2 == 0)
            lista.push_back(new Cachorro());
        else
            lista.push_back(new Gato());
    }

    for (auto a : lista)
        a->fale();

    // Liberar memória
    for (auto a : lista)
        delete a;

    return 0;
}
