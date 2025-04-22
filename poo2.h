// MÉTODO CONSTRUTOR - CLASSE EM ARQUIVO EXTERNO .H

#ifndef POO2_H_INCLUDED
#define POO2_H_INCLUDED

using namespace std;

// Declarando uma classe
class Aviao {
public: // Elemento público
    // Declaração de parãmetros
    int vel=0; // par. 1
    int velMax; // par. 2
    std::string tipo; // par. 3
    Aviao(int tp);

    void imprimir();

private: // Elemento privado

};

// Construir método Avião
Aviao::Aviao(int tp) { // 1=Jato, 2=Monomotor, 3=Planador
    if (tp==1) {
        velMax=800;
        tipo="Jato";
    } else if (tp==2) {
        velMax=350;
        tipo="Monomotor";
    } else if (tp==3) {
        velMax=180;
        tipo="Planador";
    }
}

void Aviao::imprimir() {
    std::cout << "Tipo.............: " << tipo << std::endl;
    std::cout << "Velocidade máxima: " << velMax << std::endl;
    std::cout << "Velocidade atual.: " << vel << std::endl;
    std::cout << "-----------------------------------------" << std::endl;
}

#endif // POO2_H_INCLUDED