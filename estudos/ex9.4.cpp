/*
Aula 13/05/2025

g++ -g -o poo4 poo4.cpp
gdb ./poo4
break main
run
next
print (variavel)
gdb info variables

Exemplo de uso de template de função de classe:
*/

#include <iostream>
using namespace std;

class Util {
public:
    template<typename T>
    static T maior(T a, T b) {
        return (a > b) ? a : b;
    }
};

int main() {
    cout << "Maior entre 5 e 10: " << Util::maior(5, 10) << endl;
    cout << "Maior entre 3.14 e 2.71: " << Util::maior(3.14, 2.71) << endl;
    cout << "Maior entre 'Lucas' e 'Ana': " << Util::maior(string("Lucas"), string("Ana")) << endl;

    return 0;
}
