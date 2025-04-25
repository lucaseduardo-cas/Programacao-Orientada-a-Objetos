#include <iostream>
using namespace std;

// Classe genérica Animal
class Animal {
protected:
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

    // Métodos Getters
    string getNome() const { return nome; }
    int getIdade() const { return idade; }

    // Métodos Setters
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
        cout << "Construtor chamado para Mamífero: " << nome << endl;
    }

    // Destrutor
    ~Mamifero() {
        cout << "Destrutor chamado para Mamífero: " << nome << endl;
    }

    // Métodos Getters
    string getTipoPelo() const { return tipoPelo; }

    // Métodos Setters
    void setTipoPelo(string novoTipoPelo) { tipoPelo = novoTipoPelo; }

    void exibirDados() {
        cout << "Nome: " << nome << ", Idade: " << idade << ", Tipo de pelo: " << tipoPelo << endl;
    }
};

// Classe especializada Réptil
class Reptil : public Animal {
private:
    bool temEscamas;

public:
    // Construtor
    Reptil(string nome, int idade, bool temEscamas) : Animal(nome, idade) {
        this->temEscamas = temEscamas;
        cout << "Construtor chamado para Réptil: " << nome << endl;
    }

    // Destrutor
    ~Reptil() {
        cout << "Destrutor chamado para Réptil: " << nome << endl;
    }

    // Métodos Getters
    bool getTemEscamas() const { return temEscamas; }

    // Métodos Setters
    void setTemEscamas(bool novoTemEscamas) { temEscamas = novoTemEscamas; }

    void exibirDados() {
        cout << "Nome: " << nome << ", Idade: " << idade << ", Tem escamas: " << (temEscamas ? "Sim" : "Não") << endl;
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
