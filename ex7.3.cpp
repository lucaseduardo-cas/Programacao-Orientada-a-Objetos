/*
1. O que é sobrecarga de método (overloading)?
É quando dois ou mais métodos têm o mesmo nome, mas assinaturas diferentes (parâmetros diferentes) dentro da mesma classe ou classe derivada.

class Exemplo {
public:
    void mostrar();              // Método 1
    void mostrar(string texto); // Método 2 (sobrecarga)
};


2. E herança?
Herança é quando uma classe filha herda atributos e métodos de uma classe pai:
class Pai {
public:
    void falar() { cout << "Pai falando\n"; }
};

class Filho : public Pai {
public:
    void falar(string msg) { cout << "Filho diz: " << msg << endl; }
};


3. A pegadinha: quando há herança + sobrecarga
No exemplo acima, pode parecer que o objeto da classe Filho tem acesso aos dois métodos falar() (com e sem parâmetro). Mas não tem!

Por quê?
Porque em C++, um método na classe filha com o mesmo nome de um método da classe pai "esconde" todos os métodos da classe pai com o mesmo nome ? mesmo que a assinatura seja diferente.

Como resolver?
Use o comando using para ?herdar visivelmente? os métodos da classe base:
*/

#include <iostream>
using namespace std;

class Pai {
public:
    void falar() { cout << "Pai falando\n"; }
};

class Filho : public Pai {
public:
    using Pai::falar; // Reexpondo o método da classe Pai (Se tirar não funciona)
    void falar(string msg) { cout << "Filho diz: " << msg << endl; }
};

int main() {
    Filho f;
    f.falar(); // ERRO: método 'falar()' sem argumento está ocultado!
    f.falar("Oi");
}
