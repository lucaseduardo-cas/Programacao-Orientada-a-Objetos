//g++ -g programa.cpp -o programa
//gdb ./programa
//break Pessoa::Pessoa
//break Pessoa::~Pessoa
//run
//print nome
//continue
/*
4- Tarefa 25/03/2025: Definir uma classe para representar o cliente de um banco. Pelo menos 4
atributos e 4 métodos.
(banco), tem que ter o saldo e identificador do cliente e o identificador não pode ser o nome do cliente.
Não é pra usar o "construtor" e também definir no mínimo 4 métodos para manipular os atributos de cada
cliente. Ex.: 
método saque, tem que trabalhar saldo e subtrair e parâmetro que estou passando. Se estou criando um
depósito tem que somar.
*/

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
    Pessoa pessoa1("Talles");

    pessoa1.exibirNome();

    cout << "Encerrando programa...\n";
    return 0;
}