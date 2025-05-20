Ã¯Â»Â¿/*
Aula 13/05/2025

g++ -g -o poo4 poo4.cpp
gdb ./poo4
break main
run
next
print (variavel)
gdb info variables

Trazer um exemplo do uso de sobrecarga de método de função virtual (ou de método virtual), ou seja, de sobrescrito.
*/

#include <iostream>
#include <string>
using namespace std;

class Veiculo {
public:
    string marca;
    string modelo;

    Veiculo(string m, string mod) : marca(m), modelo(mod) {}

    virtual void exibir() {
        cout << "Veículo: " << marca << " " << modelo << endl;
    }
};

class Carro : public Veiculo {
public:
    string chassi;

    Carro(string m, string mod, string ch) : Veiculo(m, mod), chassi(ch) {}

    void exibir() override {
        cout << "Carro: " << marca << " " << modelo << ", Chassi: " << chassi << endl;
    }
};

class Motocicleta : public Veiculo {
public:
    string cor;

    Motocicleta(string m, string mod, string c) : Veiculo(m, mod), cor(c) {}

    void exibir() override {
        cout << "Motocicleta: " << marca << " " << modelo << ", Cor: " << cor << endl;
    }
};

int main() {
    Veiculo* v1 = new Carro("Honda", "Civic", "12345");
    Veiculo* v2 = new Motocicleta("Yamaha", "Fazer", "Vermelha");

    v1->exibir();  // Chama exibir() da classe Carro
    v2->exibir();  // Chama exibir() da classe Motocicleta

    delete v1;
    delete v2;

    return 0;
}
