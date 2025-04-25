/*
Tarefa 01/04/2025: Escreva um programa com duas classes que apresentem um relacionamento por herança. O programa deverão apresentar, 
construir, destruir, getter, setter. No exemplo, deverão ser explorados os modificadores de tipos para atributos.

protected	- Dentro da classe e das classes filhas	(Permitir herança com controle)
private	    - Somente dentro da própria classe (Você quer esconder os dados de fora)
public	    - Livre acesso de fora da classe (Quando precisa ser acessado externamente)
*/

#include <iostream>
using namespace std;

// Classe genérica Animal
class Animal {
private:
    string nome;
    int idade;

public:
    // Construtor
    Animal(string nome, int idade) {
        this->nome = nome;
        this->idade = idade;
        cout << "Construtor chamado para Animal: " << nome << endl;
    }

    // Destrutor
    ~Animal() {
        cout << "Destrutor chamado para Animal: " << nome << endl;
    }

    // Método Getters
    string getNome() const { return nome; }
    int getIdade() const { return idade; }

    // Método Setters
    void setNome(string novoNome) { nome = novoNome; }
    void setIdade(int novaIdade) { idade = novaIdade; }
};

// Classe especializada Mamífero
class Mamifero : public Animal {
private:
    string tipoPelo;

public:
    // Construtor
    Mamifero(string nome, int idade, string tipoPelo) : Animal(nome, idade) {
        this->tipoPelo = tipoPelo;
        // cout << "Construtor chamado para Mamífero: " << nome << endl;
        cout << "Construtor chamado para MamÃ­fero: " << getNome() << endl;
    }

    // Destrutor
    ~Mamifero() {
        //cout << "Destrutor chamado para Mamífero: " << nome << endl;
        cout << "Destrutor chamado para MamÃ­fero: " << getNome() << endl;
    }

    // Métodos Getters
    string getTipoPelo() const { return tipoPelo; }

    // Métodos Setters
    void setTipoPelo(string novoTipoPelo) { tipoPelo = novoTipoPelo; }

    void exibirDados() {
        //cout << "Nome: " << nome << ", Idade: " << idade << ", Tipo de pelo: " << tipoPelo << endl;
        cout << "Nome: " << getNome() << ", Idade: " << getIdade() << ", Tipo de pelo: " << tipoPelo << endl;
    }
};

// Classe especializada Reptil
class Reptil : public Animal {
private:
    bool temEscamas;

public:
    // Construtor
    Reptil(string nome, int idade, bool temEscamas) : Animal(nome, idade) {
        this->temEscamas = temEscamas;
        //cout << "Construtor chamado para Reptil: " << nome << endl;
        cout << "Construtor chamado para RÃ©ptil: " << getNome() << endl;
    }

    // Destrutor
    ~Reptil() {
        //cout << "Destrutor chamado para Reptil: " << nome << endl;
        cout << "Destrutor chamado para RÃ©ptil: " << getNome() << endl;
    }

    // Métodos Getters
    bool getTemEscamas() const { return temEscamas; }

    // Métodos Setters
    void setTemEscamas(bool novoTemEscamas) { temEscamas = novoTemEscamas; }

    void exibirDados() {
        //cout << "Nome: " << nome << ", Idade: " << idade << ", Tem escamas: " << (temEscamas ? "Sim" : "Não") << endl;
        cout << "Nome: " << getNome() << ", Idade: " << getIdade() << ", Tem escamas: " << (temEscamas ? "Sim" : "Não") << endl;
    }
};

int main() {
    cout << "Criando um Mamífero e um Réptil...\n";
    Mamifero cachorro("Rex", 5, "Curto");
    Reptil cobra("Naja", 3, true);

    cout << "\nExibindo dados:\n";
    cachorro.exibirDados();
    cobra.exibirDados();

    cout << "\nModificando atributos...\n";
    cachorro.setIdade(6);
    cachorro.setTipoPelo("Longo");
    cobra.setTemEscamas(false);

    cout << "\nDados atualizados:\n";
    cachorro.exibirDados();
    cobra.exibirDados();

    cout << "\nEncerrando programa...\n";
    return 0;
}