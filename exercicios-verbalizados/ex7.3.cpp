/*
N:N ? Um Aluno pode estar em várias Disciplinas, e uma Disciplina pode ter vários Alunos.

Aluno ---------N:N--------- Disciplina
+ nome                           + nome
+ disciplinas: vector*           + alunos: vector*
+ getNome()                      + listarAlunos()

*/

#include <iostream>
#include <vector>
using namespace std;

class Disciplina;

class Aluno {
private:
    string nome;
    vector<Disciplina*> disciplinas;
public:
    Aluno(string nome) : nome(nome) {}

    void adicionarDisciplina(Disciplina* d) {
        disciplinas.push_back(d);
    }

    void listarDisciplinas();
    string getNome() const { return nome; }
};

class Disciplina {
private:
    string nome;
    vector<Aluno*> alunos;
public:
    Disciplina(string nome) : nome(nome) {}

    void adicionarAluno(Aluno* a) {
        alunos.push_back(a);
    }

    void listarAlunos() {
        cout << "Disciplina: " << nome << endl;
        for (Aluno* a : alunos) {
            cout << "- Aluno: " << a->getNome() << endl;
        }
    }

    string getNome() const { return nome; }
};

void Aluno::listarDisciplinas() {
    cout << "Aluno: " << nome << endl;
    for (Disciplina* d : disciplinas) {
        cout << "- Disciplina: " << d->getNome() << endl;
    }
}

int main() {
    Aluno a1("Lucas"), a2("Fernanda");
    Disciplina d1("POO"), d2("Matemática");

    a1.adicionarDisciplina(&d1);
    a1.adicionarDisciplina(&d2);
    a2.adicionarDisciplina(&d1);

    d1.adicionarAluno(&a1);
    d1.adicionarAluno(&a2);
    d2.adicionarAluno(&a1);

    a1.listarDisciplinas();
    d1.listarAlunos();

    return 0;
}
