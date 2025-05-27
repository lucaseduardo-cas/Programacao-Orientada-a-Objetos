/*
Tarefa 25/02/2025: Construa um tipo abstrato de dados que contenha pelo menos 2 atributos e 2 métodos que vão 
manipular os atributos. Ou seja, definir uma classe com 2 métodos e 2 atributos. Além disso, construir um 
programa em linguagem C++ para implementar o tipo abstrato de dados (TAD). 
*/

#include <iostream>  // Biblioteca para entrada e saída de dados
#include <string>    // Biblioteca para manipular strings

// Definição da classe Pessoa
class Pessoa {
private:
    std::string nome; // Atributo nome
    int idade; // Atributo idade

public:
    // Método para definir os dados da pessoa
    void definirDados(std::string n, int i) {
        nome = n;
        idade = i;
    }

    // Método para mostrar os dados da pessoa
    void mostrarDados() {
        std::cout << "Nome: " << nome << std::endl;
        std::cout << "Idade: " << idade << " anos" << std::endl;
    }
};

// Função principal (main) do programa
int main() {
    Pessoa p1;  // Criando um objeto da classe Pessoa
    std::string nome;
    int idade;

    // Entrada de dados
    std::cout << "Digite o nome: ";
    std::getline(std::cin, nome);  // Lê o nome completo

    std::cout << "Digite a idade: ";
    std::cin >> idade; // Lê a idade

    // Definindo os dados da pessoa
    p1.definirDados(nome, idade);

    // Exibindo os dados da pessoa
    std::cout << "\nInformações da pessoa:" << std::endl;
    p1.mostrarDados();

    return 0;
}
