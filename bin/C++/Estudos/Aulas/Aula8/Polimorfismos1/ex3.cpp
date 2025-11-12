/*
Tipos de polimorfismo:

* UNIVERSAL:
    - Universal ou verdadeiro
        - Quando uma função ou tipo trabalha de
        maneira uniforme para uma gama de tipos
        definidos na linguagem
    - A mesma definição (código) de uma função
    pode ser utilizada por diferentes tipos
    - Potencialmente número infinito de variações

* UNIVERSAL - PARAMÉTRICO
    - Torna a linguagem mais expressiva
        - Templates em C++ (Generics em Java)
    - Implícito
        - Os tipos são identificados pelo compilador
        - São passados implicitamente à função
    - Explícito
        - Os tipos são passados como parâmetros
*/

#include <iostream>
#include <list>

int main() {
    std::list<int> l = {7, 5, 16, 8};

    l.push_front(25);
    l.push_back(13);

    for (std::list<int>::iterator it=l.begin(); it != l.end(); ++it) {
        std::cout << *it << std::endl;
    }

    return 0;
}
