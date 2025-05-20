/*
1. O que � sobrecarga de m�todo (overloading)?
� quando dois ou mais m�todos t�m o mesmo nome, mas assinaturas diferentes (par�metros diferentes) dentro da mesma classe ou classe derivada.

class Exemplo {
public:
    void mostrar();              // M�todo 1
    void mostrar(string texto); // M�todo 2 (sobrecarga)
};


2. E heran�a?
Heran�a � quando uma classe filha herda atributos e m�todos de uma classe pai:
class Pai {
public:
    void falar() { cout << "Pai falando\n"; }
};

class Filho : public Pai {
public:
    void falar(string msg) { cout << "Filho diz: " << msg << endl; }
};


3. A pegadinha: quando h� heran�a + sobrecarga
No exemplo acima, pode parecer que o objeto da classe Filho tem acesso aos dois m�todos falar() (com e sem par�metro). Mas n�o tem!

Por qu�?
Porque em C++, um m�todo na classe filha com o mesmo nome de um m�todo da classe pai "esconde" todos os m�todos da classe pai com o mesmo nome ? mesmo que a assinatura seja diferente.

Como resolver?
Use o comando using para ?herdar visivelmente? os m�todos da classe base:
*/

#include <iostream>
using namespace std;

class Pai {
public:
    void falar() { cout << "Pai falando\n"; }
};

class Filho : public Pai {
public:
    using Pai::falar; // Reexpondo o m�todo da classe Pai (Se tirar n�o funciona)
    void falar(string msg) { cout << "Filho diz: " << msg << endl; }
};

int main() {
    Filho f;
    f.falar(); // ERRO: m�todo 'falar()' sem argumento est� ocultado!
    f.falar("Oi");
}
