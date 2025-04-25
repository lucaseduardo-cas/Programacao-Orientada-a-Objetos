/*
Tarefa 25/02/2025: Construir um programa em linguagem C++ para implementar o tipo abstrato de dados (TAD). 
*/

#include <iostream>
#include <string>
using namespace std;

// Definindo um Tipo Abstrato de Dados (TAD) chamado Produto
class Produto {
private:
    string nome;
    float preco;

public:
    // Método para definir os dados do produto
    void definirDados(string n, float p) {
        nome = n;
        preco = p;
    }

    // Método para mostrar os dados do produto
    void mostrarDados() {
        cout << "Produto: " << nome << endl;
        cout << "Preço: R$ " << preco << endl;
    }
};

int main() {
    Produto p1;
    string nome;
    float preco;

    cout << "Digite o nome do produto: ";
    getline(cin, nome);

    cout << "Digite o preço do produto: ";
    cin >> preco;

    p1.definirDados(nome, preco);

    cout << "\nInformações do produto:" << endl;
    p1.mostrarDados();

    return 0;
}
