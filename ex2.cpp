// Exemplo professor

#include <iostream>
#include <string>

class Aluno {
public:
    std::string nome; // Atributo público
};

int main () {
    // Criando objetos Aluno
    Aluno aluno1;
    Aluno aluno2;
    Aluno aluno3;
    Aluno aluno4;

    // Atribuindo nomes aos objetos
    aluno1.nome = "João";
    aluno2.nome = "Maria";
    aluno3.nome = "Lucas";
    aluno4.nome = "José";

    // Exibindo os nomes dos alunos
    std::cout << "Nome do aluno 1: " << aluno1.nome << std::endl;
    std::cout << "Nome do aluno 2: " << aluno2.nome << std::endl;
    std::cout << "Nome do aluno 3: " << aluno3.nome << std::endl;
    std::cout << "Nome do aluno 4: " << aluno4.nome << std::endl;

    return 0;
}