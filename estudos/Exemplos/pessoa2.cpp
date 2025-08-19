//gcc -g -o pessoa2 pessoa2.cpp
//gdb ./pessoa2
//(gdb) b main
//(gdb) run
//(gdb) next
//(gdb) print pessoa1
//(gdb) next
//(gdb) print pessoa1
//(gdb) next
//(gdb) next
//(gdb) print pessoa1.cidade
//(gdb) continue
//(gdb) quit


#include <iostream>
using namespace std;

class Pessoa {
public:
    // Construtor
    Pessoa(string nome, int idade, string cidade) {
        this->nome = nome;
        this->idade = idade;
        this->cidade = cidade;
        cout << "Construtor chamado para " << nome << endl;
    }

    // Destrutor
    ~Pessoa() {
        cout << "Destrutor chamado para " << nome << endl;
    }

    void exibirDados() {
        cout << "Nome: " << nome << ", Idade: " << idade << ", Cidade: " << cidade << endl;
    }

    // Getter para idade
    int getIdade() const {
        return idade;
    }

    // Setter para idade
    void setIdade(int novaIdade) {
        idade = novaIdade;
    }

    // Getter para cidade
    string getCidade() const {
        return cidade;
    }

    // Setter para cidade
    void setCidade(string novaCidade) {
        cidade = novaCidade;
    }

private:
    string nome;
    int idade;
    string cidade;
};

int main() {
    cout << "Criando objeto...\n";
    Pessoa pessoa1("Lucas Eduardo", 26, "Goiânia");

    pessoa1.exibirDados();

    // Usando os setters para atualizar os atributos
    pessoa1.setIdade(26);
    pessoa1.setCidade("Brasília");

    cout << "Dados atualizados:\n";
    pessoa1.exibirDados();

    cout << "Encerrando programa...\n";
    return 0;
}
