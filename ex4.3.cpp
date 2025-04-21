ZIP Extractor
ZIP Extractor
Free app for opening and creating ZIP files
Lucas
Google Account
arrow_back
2503.zip
code Highlight Syntax wrap_text
unfold_more skip_previous skip_next close
code
Pessoa3.cpp (2 KB)
file_download Download CPP Save to Drive Save to Drive more_vert
#include <iostream>
using namespace std;

// Classe base Pessoa
class Pessoa {
protected:
    string nome; // Atributo protegido
    int idade;   // Atributo protegido

public:
    // Construtor
    Pessoa(string nome, int idade) {
        this->nome = nome;
        this->idade = idade;
        cout << "Construtor chamado para Pessoa: " << nome << endl;
    }

    // Destrutor
    ~Pessoa() {
        cout << "Destrutor chamado para Pessoa: " << nome << endl;
    }

    // Método público
    void exibirDados() {
        cout << "Nome: " << nome << ", Idade: " << idade << endl;
    }
};

// Subclasse Estudante
class Estudante : public Pessoa {
private:
    string curso; // Atributo privado

public:
    // Construtor
    Estudante(string nome, int idade, string curso)
        : Pessoa(nome, idade) { // Chamada ao construtor da classe base
        this->curso = curso;
        cout << "Construtor chamado para Estudante: " << nome << endl;
    }

    // Destrutor
    ~Estudante() {
        cout << "Destrutor chamado para Estudante: " << nome << endl;
    }

    // Método público para exibir todos os dados
    void exibirDadosEstudante() {
        exibirDados(); // Chama o método da classe base
        cout << "Curso: " << curso << endl;
    }

protected:
    // Método protegido
    void exibirCursoProtegido() {
        cout << "Curso (acesso protegido): " << curso << endl;
    }
};

int main() {
    // Criando objeto da classe Estudante
    cout << "Criando objeto Estudante...\n";
    Estudante estudante1("Talles", 25, "Engenharia de Software");

    // Exibindo os dados do estudante
    estudante1.exibirDadosEstudante();

    // Encerrando programa
    cout << "Encerrando programa...\n";
    return 0;
}
