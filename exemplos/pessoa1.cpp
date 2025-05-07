//g++ -g programa.cpp -o programa
//gdb ./programa
//break Pessoa::Pessoa
//break Pessoa::~Pessoa
//run
//print nome
//continue


#include <iostream>
using namespace std;

class Pessoa {
public:
    // Construtor
    Pessoa(string nome) {
        this->nome = nome;
        cout << "Construtor chamado para " << nome << endl;
    }
    
    // Destrutor
    ~Pessoa() {
        cout << "Destrutor chamado para " << nome << endl;
    }

    void exibirNome() {
        cout << "O nome é: " << nome << endl;
    }

private:
    string nome;
};

int main() {
    cout << "Criando objeto...\n";
    Pessoa pessoa1("Lucas");

    pessoa1.exibirNome();

    cout << "Encerrando programa...\n";
    return 0;
}
