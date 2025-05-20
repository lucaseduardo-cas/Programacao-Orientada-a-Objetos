/*
Aula 29/04/2024
Exercício em sala com IA. Prompt:
Gere um código simples em c++ usando uma classe calcular e na função main somando dois números

g++ -g -o poo4 poo4.cpp
gdb ./poo4
break main
run
next
print (variavel)
gdb info variables
*/

#include <iostream>
using namespace std;

class Calcular {
public:
    int somar(int a, int b) {
        return a + b;
    }
};

int main () {
    Calcular calc;
    int num1, num2, resultado;

    cout << "Digite o primeiro numero: ";
    cin >> num1;
    cout << "Digite o segundo numero: ";
    cin >> num2;

    resultado = calc.somar(num1, num2);
    cout << "A soma é: " << resultado << endl;

    return 0;

    // Que tipo de problema a sobrecarga de método é capaz de resolver com base nesse exemplo que você gerou? ex7.2.cpp
}

