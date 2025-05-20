/*
produzir exemplos de programas que utilizam relacionamento de agregação e composição entre duas classes. Além da definição das 
classes inserir métodos contrutores, destrutores e getters/setters. Verificar e analisar as diferenças quanto à execução dos 
exemplos de relacionamentos em C++.
*/

#include <iostream>
using namespace std;

// Classe Endereço (pode existir sozinha, fora da Pessoa)
class Endereco {
private:
    string rua;
    int numero;

public:
    Endereco(string rua, int numero) : rua(rua), numero(numero) {
        cout << "Construtor de Endereco chamado.\n";
    }

    ~Endereco() {
        cout << "Destrutor de Endereco chamado.\n";
    }

    string getRua() const { return rua; }
    int getNumero() const { return numero; }

    void setRua(string novaRua) { rua = novaRua; }
    void setNumero(int novoNumero) { numero = novoNumero; }

    void exibir() const {
        cout << "Endereco: " << rua << ", " << numero << endl;
    }
};

// Classe Pessoa possui um Endereco — Agregação (recebe por ponteiro)
class Pessoa {
private:
    string nome;
    Endereco* endereco; // Pessoa "tem um" Endereco (mas ele pode existir sem a Pessoa)

public:
    Pessoa(string nome, Endereco* endereco) : nome(nome), endereco(endereco) {
        cout << "Construtor de Pessoa chamado.\n";
    }

    ~Pessoa() {
        cout << "Destrutor de Pessoa chamado.\n";
        // Não deletamos o endereço, pois ele pode ser compartilhado ou viver fora da Pessoa
    }

    string getNome() const { return nome; }
    void setNome(string novoNome) { nome = novoNome; }

    void exibir() const {
        cout << "Pessoa: " << nome << endl;
        endereco->exibir(); // acessando o endereço agregado
    }
};

// Classe Motor (só existe se o Carro existir)
class Motor {
    private:
    int potencia;

public:
    Motor(int potencia) : potencia(potencia) {
        cout << "Construtor de Motor chamado.\n";
    }

    ~Motor() {
        cout << "Destrutor de Motor chamado.\n";
    }

    int getPotencia() const { return potencia; }
    void setPotencia(int novaPotencia) { potencia = novaPotencia; }

    void exibir() const {
        cout << "Motor com " << potencia << " cavalos de potência.\n";
    }
};

// Classe Carro possui um Motor — Composição (instanciado internamente)
class Carro {
private:
    string modelo;
    Motor motor; // Composição: Motor faz parte do Carro

public:
    Carro(string modelo, int potenciaMotor) : modelo(modelo), motor(potenciaMotor) {
        cout << "Construtor de Carro chamado.\n";
    }

    ~Carro() {
        cout << "Destrutor de Carro chamado.\n";
    }

    void setModelo(string novoModelo) { modelo = novoModelo; }
    string getModelo() const { return modelo; }

    void exibir() const {
        cout << "Carro modelo: " << modelo << endl;
        motor.exibir(); // Motor interno ao carro
    }    
};
    
int main() {
    cout << "--- Exemplo de Agregação ---\n";
    Endereco* endereco1 = new Endereco("Rua das Flores", 123); // criado fora da Pessoa
    Pessoa pessoa1("João", endereco1);
    pessoa1.exibir();
    delete endereco1; // precisa deletar manualmente (foi criado com new)

    cout << "\n--- Exemplo de Composição ---\n";
    Carro carro1("Fusca", 85);
    carro1.exibir();

    cout << "\nEncerrando programa...\n";
    return 0;        
}
    