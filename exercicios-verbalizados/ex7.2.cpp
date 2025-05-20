/*
1:N ? Um Professor pode ter várias Turmas, mas cada Turma tem apenas um Professor.

Professor ---------1:N--------- Turma
+ nome                           + nome
+ turmas: vector<Turma>          + getNome()

*/

#include <iostream>
#include <vector>
using namespace std;

class Turma {
private:
    string nome;
public:
    Turma(string nome) : nome(nome) {}
    string getNome() const { return nome; }
};

class Professor {
private:
    string nome;
    vector<Turma> turmas;
public:
    Professor(string nome) : nome(nome) {}

    void adicionarTurma(Turma t) {
        turmas.push_back(t);
    }

    void listarTurmas() {
        cout << "Professor: " << nome << endl;
        for (Turma t : turmas) {
            cout << "- Turma: " << t.getNome() << endl;
        }
    }
};

int main() {
    Professor prof("Maria");
    prof.adicionarTurma(Turma("1A"));
    prof.adicionarTurma(Turma("2B"));
    prof.listarTurmas();

    return 0;
}
