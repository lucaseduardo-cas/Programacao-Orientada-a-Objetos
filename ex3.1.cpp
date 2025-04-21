#include <iostream>
#include <string>

class Aluno {
private: // Só pode ser acessado de dentro da própria classe.
    std::string nome; // Atributo da classe

public: // Pode ser acessado fora da classe, como por exemplo no main().
    // Construtor
    Aluno(const std::string& nome) : nome(nome) {}

    // Método para exibir o nome do aluno
    void exibirNome() const {
        std::cout << "Nome: " << nome << std::endl;
    }
};

// argc = argument count -> é a quantidade de argumentos passados na linha de comando.
// argv[] = argument vector -> é um vetor de strings (na verdade char*) que representa os argumentos.
int main(int argc, char* argv[]) {
    // Imprime mensagem de erro no terminal usando std::cerr (que é como std::cout, mas para erros).
    // caso não tenha passado 2 argumentos
    if (argc != 2) {
        std::cerr << "Uso: " << argv[0] << " <nome_do_aluno>" << std::endl;
        return 1;
    }

    // Obtendo o nome do aluno a partir dos argumentos da linha de comando
    std::string nome = argv[1]; // converte char* para std::string, que é o tipo moderno e mais seguro em C++.

    // Criando um objeto da classe Aluno chamado aluno1
    // O nome que você digiou na linha de comando está sendo passado para o construtor
    Aluno aluno1(nome); // Chama construtor

    // Exibindo o método público: função exibirNome
    aluno1.exibirNome();

    return 0;
}