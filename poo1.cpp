/*
//g++ -g programa.cpp -o programa
//gdb ./programa
//break Pessoa::Pessoa
//break Pessoa::~Pessoa
//run
//print nome
//continue
*/

#include <iostream>

using namespace std;

// Declarando uma classe
class Aviao {
public: // Elemento público
    // Declaração de parãmetros
    int vel=0; // par. 1
    int velMax; // par. 2
    string tipo; // par. 3
    void ini (int tp); // Declaração de método chamado "ini", que recebe um parametro inteiro chamado "tp"

private: // Elemento privado

};

// Construir método ini
void Aviao::ini(int tp) { // 1=Jato, 2=Monomotor, 3=Planador
    if (tp==1) {
        this->velMax=800;
        this->tipo="Jato";
    } else if (tp==2) {
        this->velMax=350;
        this->tipo="Monomotor";
    } else if (tp==3) {
        this->velMax=180;
        this->tipo="Planador";
    }
}

int main () {
    // Novo objeto do tipo Aviao
    Aviao *av1=new Aviao();
    Aviao *av2=new Aviao();
    Aviao *av3=new Aviao();

    // Chamando método de inicialização
    av1->ini(1);
    av2->ini(2);
    av3->ini(3);

    // Imprimindo o valor da propriedade velMax relacionado ao objeto av1
    cout << av1->velMax << endl;
    cout << av2->velMax << endl;
    cout << av3->velMax << endl;

    // Libera a memória alocada
    delete av1;
    delete av2;
    delete av3;

    return 0;
}