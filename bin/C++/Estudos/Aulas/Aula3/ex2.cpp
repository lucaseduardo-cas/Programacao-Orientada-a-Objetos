/*
g++ -g programa.cpp -o programa
gdb ./programa
break Pessoa::Pessoa
break Pessoa::~Pessoa
run
print nome
continue

3- Tarefa 11/03/2025: Tarefa POO - Modificar o exemplo aluno3.cpp
(Classrom), incluindo mais 3 atributos e dois mÃ©tdoso.
*/

#include <iostream>
#include <string>

// Declarando classe do tipo Aluno
class Aluno {
private:
    std::string nome; //Atributo privado
    // Incluindo mais 3 atributos
    int idade;
    std::string matricula;
    int sala;

public:
    // Construtor
    Aluno(const std::string& nome, int idade, std::string& matricula) : nome(nome),
    idade(idade), matricula(matricula) {}

    // Método para exibir o nome do aluno
    void exibirNome() const {
        std::cout <<"Nome: " << nome << std::endl;
    }

    // Incluindo mais 2 Método
    // Método para exibir a idade do aluno
    void exibirIdade() const {
        std::cout <<"Idade: " << idade << std::endl;
    }

    // Método para exibir a idade do aluno
    void exibirMatricula() const {
        std::cout <<"Matrícula: " << matricula << std::endl;
    }

    /*void exibirSala() const {
        std::cout <<"Sala: " << sala << std::endl;
    }*/
};

int main(int argc, char* argv[]) { // arcg = argument cout | argv = argument vector
    if (argc != 4) {
        std::cerr << "Uso: " << argv[0] << " <nome> <idade> <matricula>" << std::endl;
        //std::cerr << "Exemplo: " <<argv[0] << "Lucas, idade, 001234" << std::endl;
        return 1;
    }

    // Obtendo o nome do aluno a partir dos argumentos da linha de comando
    std::string nome = argv[1];
    int idade = std::stoi(argv[2]); // Converte string para int
    std::string matricula = argv[3];
    //int sala = std::stoi(argv[4]);

    // Criando um objeto Aluno
    Aluno aluno1(nome, idade, matricula);

    // Exibindo o nome do aluno
    aluno1.exibirNome();
    aluno1.exibirIdade(); // Chamando mï¿½todo idade
    aluno1.exibirMatricula(); // Chamando mï¿½todo matricula

    return 0;
}
