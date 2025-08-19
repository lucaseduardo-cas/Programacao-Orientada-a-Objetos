// // M�TODO CONSTRUTOR - CLASSE EM ARQUIVO EXTERNO .H

#ifndef POO3_H_INCLUDED
#define POO3_H_INCLUDED

using namespace std;

class Veiculo {
public:
    int vel;
    int tipo;
    Veiculo(int tp); // M�todo construtor
    int getVelMax(); // M�todo gatter
    bool getLigado(); // M�todo gatter
    void setLigado(int l); // M�todo setter
private:
    string nome;
    int velMax;
    bool ligado;
    void setVelMax(int vm); // M�todo setter
};

int Veiculo::getVelMax() {
    return velMax;
}

bool Veiculo::getLigado() {
    return ligado;
}

void Veiculo::setLigado(int l) {
    if(l==1) {
        ligado=true;
    } else if(l==0) {
        ligado=false;
    }
}

void Veiculo::setVelMax(int vm) {
    velMax=vm;
}

Veiculo::Veiculo(int tp) { //Tipo 1=Carro; Tipo 2=Avi�o; Tipo 3=Navio
    tipo=tp;
    if (tp==1) {
        nome="Carro";
        velMax=(200);
    } else if (tp==2) {
        nome="Avi�o";
        velMax=(800);
    } else if (tp==3) {
        nome="Navio";
        velMax=(120);
    }

    setLigado(0);
}

#endif // POO3_H_INCLUDED
