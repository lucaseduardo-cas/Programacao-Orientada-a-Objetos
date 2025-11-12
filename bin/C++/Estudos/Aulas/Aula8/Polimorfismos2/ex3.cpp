/*
Aula 06/05/2025 - Polimorfismo por Inclusão (Polimorfismo Dinâmico)

Tarefa: Tarefa, trabalhar os exemplos do slide, variações e usar o gdb até o fim
* Obs.: Os professores dos slides tem canais no youtube


Explicação breve do conceito: (EXEMPLO VIA CHAT GPT EM SALA)
- Ocorre quando um objeto de uma classe derivada pode ser tratado como um objeto de sua classe base.
- Você cria um ponteiro da classe base A (A *pa) e o faz apontar para um objeto da classe derivada B (new B()). Isso é uma atribuição válida devido à herança.
- A palavra-chave virtual no método f() da classe A habilita o despacho dinâmico (dynamic dispatch). Isso significa que, em tempo de execução, o compilador determina qual versão de f() deve ser chamada com base no tipo real do objeto para o qual o ponteiro aponta, e não no tipo do ponteiro.
- A palavra-chave override em B::f() é opcional (mas recomendada no C++ moderno) e serve para indicar explicitamente que o método está sobrescrevendo um método virtual da classe base, ajudando o compilador a detectar erros.
- Quando você chama pa->f(), embora pa seja um ponteiro do tipo A, o programa executa o método f() da classe B porque o objeto real alocado é do tipo B. Isso resulta na saída "B::f()".

Faça um exemplo simples usando o método virtual e overrode em C++:
*/

#include <iostream>

//using namespace std;

class A { // Classe base: A
public:
    virtual void f() {
        std::cout << "A::f()" << std::endl;
    }
};

class B : public A { // Classe derivada B
public:
    void f() override {
        std::cout << "B::f()" << std::endl;
    }
};

int main () {
    A *pa = new B ();
    pa ->f();

    delete pa;

    return 0;
}
