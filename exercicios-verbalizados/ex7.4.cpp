/*
Item 2. Da mesma forma que o item 1, explore o conceito de heran�a�m�ltipla.
*/

#include <iostream>
using namespace std;

class Pessoa {
protected:
    string nome;
public:
    Pessoa(string nome) : nome(nome) {}
    void mostrarNome() {
        cout << "Nome: " << nome << endl;
    }
};

class Trabalhador {
protected:
    float salario;
public:
    Trabalhador(float salario) : salario(salario) {}
    void mostrarSalario() {
        cout << "Sal�rio: R$ " << salario << endl;
    }
};

class Estudante {
protected:
    string matricula;
public:
    Estudante(string matricula) : matricula(matricula) {}
    void mostrarMatricula() {
        cout << "Matr�cula: " << matricula << endl;
    }
};

// Heran�a m�ltipla: Estagi�rio herda de Pessoa, Trabalhador e Estudante
class Estagiario : public Pessoa, public Trabalhador, public Estudante {
public:
    Estagiario(string nome, float salario, string matricula)
        : Pessoa(nome), Trabalhador(salario), Estudante(matricula) {}

    void mostrarDados() {
        mostrarNome();
        mostrarSalario();
        mostrarMatricula();
    }
};

int main() {
    Estagiario e("Lucas", 1500.00, "2025001");
    e.mostrarDados();
    return 0;
}
