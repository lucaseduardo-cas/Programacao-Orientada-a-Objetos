// // MÉTODO CONSTRUTOR - CLASSE EM ARQUIVO EXTERNO .H

#ifndef POO3_H_INCLUDED
#define POO3_H_INCLUDED

using namespace std;

class Veiculo {
public:
    int vel;
    int tipo;
    Veiculo(int tp); // Método construtor
    int getVelMax(); // Método gatter
    bool getLigado(); // Método gatter
    void setLigado(int l); // Método setter
private:
    string nome;
    int velMax;
    bool ligado;
    void setVelMax(int vm); // Método setter
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

Veiculo::Veiculo(int tp) { //Tipo 1=Carro; Tipo 2=Avião; Tipo 3=Navio
    tipo=tp;
    if (tp==1) {
        nome="Carro";
        velMax=(200);
    } else if (tp==2) {
        nome="Avião";
        velMax=(800);
    } else if (tp==3) {
        nome="Navio";
        velMax=(120);
    }

    setLigado(0);
}

#endif // POO3_H_INCLUDED
