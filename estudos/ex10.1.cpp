/*
Aula 20/05/2025

g++ -g -o poo4 poo4.cpp
gdb ./poo4
break main
run
next
bt -full
print (variavel)
gdb info variables

try {
    // Bloco que queremos proteger
} catch() // Captura e tratamento da exceção, sendo "()" o tipo de exceção

try: trecho do código que pode ocorrer algum tipo de falha
catch: captura de falha
throw: (tratador) caso ocorra uma falha
*/

#include <iostream>

int main () {
    int dividendo, divisor=1, quociente;

    std::cout << "dividendo: ";
    std::cin >> dividendo;
    std::cout << "divisor: ";
    std::cin >> divisor;

    // Bloco try é o que será protegido
    try {
        if (divisor == 0) {
            throw 1;
        }
        if (divisor < 0) {
            throw 2;
        }

        quociente = dividendo / divisor;

        std::cout << "Quociente: " << quociente << std::endl;
        return 0;
    }

    catch(...) { // Quando coloca 3 pontos, toda exceção que acontecer TEM que mostrar
        std::cout << "Exceção!" << std::endl;
        return 1;
    }
}
