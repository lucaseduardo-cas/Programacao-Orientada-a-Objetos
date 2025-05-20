/*
Aula 29/04/2024
Exerc�cio em sala com IA. Prompt:
Gere um c�digo simples em c++ usando uma classe calcular e na fun��o main somando dois n�meros

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
    cout << "A soma �: " << resultado << endl;

    return 0;

    // Que tipo de problema a sobrecarga de m�todo � capaz de resolver com base nesse exemplo que voc� gerou? ex7.2.cpp
}

