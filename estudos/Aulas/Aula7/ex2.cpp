/*
Aula 29/04/2024
Que tipo de problema a sobrecarga de método é capaz de resolver com base nesse exemplo que você gerou? ex7.2.cpp

A sobrecarga de método em C++ permite que você tenha vários métodos com o mesmo nome dentro da mesma classe, mas
com parâmetros diferentes (tipo, quantidade ou ordem). Com base no exemplo da classe Calcular, ela pode resolver
o problema de flexibilidade no uso da função somar, dependendo do tipo de dados ou da quantidade de argumentos.

Exemplo de problema que a sobrecarga resolve:
Imagine que você quer somar:
- dois ints,
- dois floats,
- ou até três números de uma vez.

Com sobrecarga, você pode fazer isso sem mudar o nome da função:
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
