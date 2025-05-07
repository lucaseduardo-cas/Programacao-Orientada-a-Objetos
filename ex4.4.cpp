/*
Tarefa 23/03/2025
1- Estudar exemplo (verificar a escrita e execução - compilar, por pra rodar e depuração, verificar o que está acontecendo com os 
atributos e métodos do programa).

2- Criar uma classe genérica e duas classes especializadas, sendo uma mais genérica chamada "animal" e depois criar classes mais 
específicas, por exemplo: "mamífero", "réptil" cujo relacionamento da classe genérica será por herança simples. Definir pelo menos 
2 atributos para cada uma das classes. Definir método construtor e destrutor para cada uma dessas classes e pelo menos mais dois 
métodos de get e set para cada uma das classes. 
Avaliar o efeito da execução quando modificar os tipos de acesso entre os atributos de classe genérica e a classe especializada 
(definir tudo como público, depois protegido e depois como privado. Rastrear com o GDB para ver o que está acontecendo lá).

- Trabalhar Geter e Setter
- Trabalhar Herança
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
        cout << "Construtor chamado para Mamífero: " << getNome() << endl;
    }

    // Destrutor
    ~Mamifero() {
        //cout << "Destrutor chamado para Mamífero: " << nome << endl;
        cout << "Destrutor chamado para Mamífero: " << getNome() << endl;
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
