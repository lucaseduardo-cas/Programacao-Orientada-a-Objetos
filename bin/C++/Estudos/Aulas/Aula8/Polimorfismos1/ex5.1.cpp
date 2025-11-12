/*
* AD-HOC
    - Ad-hoc ou aparente
        - Quando uma função ou tipo parece trabalhar
        para tipos diferentes e pode se comportar de
        formas diferentes para cada tipo
    - Número finito de entidades distintas, todas
    com mesmo nome, mas códigos distintos
    - Função ou valor conforme o contexto

* AD-SOBRECARGA
    - O mesmo identificador denota diferentes
    funções que operam sobre tipos distintos
    - Resolvido estaticamente (compilação)
        - Considera os tipos para escolher a definição
        - Difere no número e no tipo dos parâmetros
*/

#include <iostream>
#include <list>
using namespace std;

class Ponto {
private:
    int _x;
    int _y;

public:
    Ponto() : Ponto(-1, -1) {}
    Ponto(int xy) : Ponto(xy, xy) {}
    Ponto(int x, int y) : _x(x), _y(y) {}
};

/*
* AD-HOC-COERÇÃO
- Conversão automática de tipo
    - Utilizada para satisfazer o contexto atual
    - Considera a definição para escolher o tipo
- Linguagem possui um mapeamento interno
*/

void f(double x) {
    cout << x << endl;
}

int main() {
    f(3.1416);
    f((short) 2);
    f('a');
    f(3);
    f(4L);
    f(5.6F);

    return 0;
}
