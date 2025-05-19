/*
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

class Livro {
private:
    string titulo;

public:
    // Construtor é chamado automaticamente quando o objeto é criado
    Livro (string nome) {
        titulo = nome;
        cout << "Livro criado com o título: " << titulo << endl;
    }
};

int main () {
    // Criando o objeto e já passando o título
    Livro l("Aventuras em C++");

    return 0;
}
