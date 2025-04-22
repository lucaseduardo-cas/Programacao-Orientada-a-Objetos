/*
Escreva um programa com duas classes que apresentem um relacionamento por herança. O programa 
deverá apresentar, construir, destruir, getter, setter. No exemplo, deverão ser explorados os 
modificadores de tipo para atributos.
*/

#include <iostream>
#include <string>

using namespace std;

// Classe base que representa uma Pessoa
class Pessoa {
private:
    string cpf; // Atributo privado: só acessível dentro da própria classe

protected:
    string nome;  // Atributo protegido: acessível na classe base e derivadas
    int idade;

public:
    // Construtor da classe Pessoa
    Pessoa(string nome, int idade, string cpf) {
        this->nome = nome;
        this->idade = idade;
        this->cpf = cpf;

        cout << "[Pessoa criada]\n";
        cout << "Nome: " << nome << ", Idade: " << idade << ", CPF: " << cpf << endl;
    }

    // Destrutor
    ~Pessoa() {
        cout << "[Destrutor de Pessoa] " << nome << endl;
    }

    // Getter para o CPF
    string getCpf() const {
        return cpf;
    }

    // Setter para o CPF
    void setCpf(string novoCpf) {
        cout << "Alterando CPF de " << cpf << " para " << novoCpf << endl;
        cpf = novoCpf;
    }

    // Getters e Setters para nome
    string getNome() const {
        return nome;
    }

    void setNome(string novoNome) {
        cout << "Alterando nome de " << nome << " para " << novoNome << endl;
        nome = novoNome;
    }

    // Getters e Setters para idade
    int getIdade() const {
        return idade;
    }

    void setIdade(int novaIdade) {
        cout << "Alterando idade de " << idade << " para " << novaIdade << endl;
        idade = novaIdade;
    }
};

// Classe derivada Estudante, que herda de Pessoa
class Estudante : public Pessoa {
private:
    string curso; // Atributo próprio da classe Estudante

public:
    // Construtor da classe Estudante
    Estudante(string nome, int idade, string cpf, string curso)
        : Pessoa(nome, idade, cpf) {
        this->curso = curso;

        cout << "[Estudante criado]\n";
        cout << "Curso: " << curso << endl;
    }

    // Destrutor
    ~Estudante() {
        cout << "[Destrutor de Estudante] " << nome << endl;
    }

    // Getter para o curso
    string getCurso() const {
        return curso;
    }

    // Setter para o curso
    void setCurso(string novoCurso) {
        cout << "Alterando curso de " << curso << " para " << novoCurso << endl;
        curso = novoCurso;
    }

    // Exibir todos os dados do estudante
    void exibirDados() const {
        cout << "\n[ DADOS DO ESTUDANTE ]\n";
        cout << "Nome: " << getNome() << endl;
        cout << "Idade: " << getIdade() << " anos" << endl;
        cout << "CPF: " << getCpf() << endl;
        cout << "Curso: " << getCurso() << endl;
    }
};

int main() {
    // Criando objeto aluno com os dados iniciais
    Estudante aluno("Lucas", 20, "000.000.000-00", "Sistemas de Informação");

    // Mostrando os dados iniciais
    aluno.exibirDados();

    // Alterando dados com os métodos setters
    cout << "\n[ ALTERAÇÕES NO OBJETO ALUNO ]\n";
    aluno.setCurso("Engenharia de Software");
    aluno.setIdade(21);
    aluno.setCpf("111.111.111-11");
    aluno.setNome("Lucas Eduardo");

    // Exibindo os dados atualizados
    cout << "\n[ DADOS ATUALIZADOS APÓS AS ALTERAÇÕES ]\n";
    aluno.exibirDados();

    return 0;
}
