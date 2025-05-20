/*
Aula 29/04/2024
Que tipo de problema a sobrecarga de m�todo � capaz de resolver com base nesse exemplo que voc� gerou? ex7.2.cpp

A sobrecarga de m�todo em C++ permite que voc� tenha v�rios m�todos com o mesmo nome dentro da mesma classe, mas
com par�metros diferentes (tipo, quantidade ou ordem). Com base no exemplo da classe Calcular, ela pode resolver
o problema de flexibilidade no uso da fun��o somar, dependendo do tipo de dados ou da quantidade de argumentos.

Exemplo de problema que a sobrecarga resolve:
Imagine que voc� quer somar:
- dois ints,
- dois floats,
- ou at� tr�s n�meros de uma vez.

Com sobrecarga, voc� pode fazer isso sem mudar o nome da fun��o:
*/

#include <iostream>
using namespace std;

class Calcular {
public:
    int somar(int a, int b) {
        return a + b;
    }

    float somar(float a, float b) {
        return a + b;
    }

    int somar(int a, int b, int c) {
        return a + b + c;
    }
};

int main () {
    Calcular calc;

    cout << "Soma de inteiros: "      << calc.somar(2,3) << endl;
    cout << "Soma de floats: "        << calc.somar(2.3f, 3.1f) << endl;
    cout << "Soma de tres inteiros: " << calc.somar(1, 2, 3) << endl;

    return 0;
}
