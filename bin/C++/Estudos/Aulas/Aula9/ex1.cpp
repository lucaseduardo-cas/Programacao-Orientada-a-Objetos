/*
Aula 13/05/2025

g++ -g -o poo4 poo4.cpp
gdb ./poo4
break main
run
next
print (variavel)
gdb info variables

Corrigir a prova e colocar para rodar junto com o gdb

1) Utilizando a linguagem de programação c++, faça a implementação do diagrama de classes, apresentado na figura 1. JUSTIFIQUE SUA RESPOTA

Figura 1 - Representação:

       PedidoOnline         ----------->           Pedido            1 ------------1       Cliente
- metodoPagamento: String                 - numero: int                              - nome: String
+ ExibirPedidoOnline(): void              - valor: double                            - email: String
                                          - cliente: Cliente                         +ExibirDadosCliente(): void
                                          + ExibirDadosPedido(): void

- Cliente, pedido e pedido online se tornam classes;
- Pedido tem um cliente associacao: 1:1;
- Pedido Online herda pedido;
- "exibirDados<> mostra os dados conforme cada classe";
*/


#include <iostream>
#include <string>
using namespace std;

class Cliente {
private:
    string nome;
    string email;

public:
    Cliente(string nome, string email) {
        this->nome = nome;
        this->email = email;
    }

    void exibirDadosCliente() {
        cout << "Nome: " << nome << ", Email: " << email << endl;
    }
};

class Pedido {
protected:
    int numero;
    double valor;
    Cliente cliente;

public:
    Pedido(int numero, double valor, Cliente cliente)
        : numero(numero), valor(valor), cliente(cliente) {}

    void exibirDadosPedidos() {
        cout << "Pedido Nº: " << numero << ", Valor: R$" << valor << endl;
        cliente.exibirDadosCliente();
    }
};

class PedidoOnline : public Pedido {
private:
    string metodoPagamento;

public:
    PedidoOnline(int numero, double valor, Cliente cliente, string metodoPagamento)
        : Pedido(numero, valor, cliente), metodoPagamento(metodoPagamento) {}

    void exibirPedidoCliente() {
        exibirDadosPedidos();
        cout << "Método de pagamento: " << metodoPagamento << endl;
    }
};

int main() {
    Cliente cliente("Joao", "joao@gmail.com");
    PedidoOnline pedido(123, 50.0, cliente, "Cartão de Crédito");

    pedido.exibirPedidoCliente();

    system("pause");

    return 0;
}



/*
#include <iostream>
#include <string>
using namespace std;

class Pedido {
private:
    int numero;
    double valor;
    cliente Cliente;

public:
    void exibirDadosPedidos (int numero, double valor, cliente Cliente) {
        this -> numero = numero;
        this -> valor = valor;
        this -> cliente = cliente;
    }
};

class Cliente {
private:
    string nome;
    string email;

public:
    void exibirDadosCliente(const string nome, const string email) {
        this -> nome = nome;
        this -> email = email;
    }
};

class PedidoOnline: Pedido {
private:
    string metodoPagamento;

public:
    void exibirPedidoCliente() {
        Pedido:exibirDadosPedidos()
        cout << "Exibir dados: " << metodoPagamento << endl;
    }
};

int main () {
    Cliente cliente = "Joao", "joao@gmail.com";
    PedidoOnline pedido = "123", "50", "Joao";

    pedido.exibirDadosPedidos();

    return 0.
}
*/

/*
✅ Correções principais com foco em POO:
1. Ausência de Construtores
No código original, as classes não têm construtores.

Isso fere o princípio de inicialização adequada de objetos, já que os atributos não eram definidos de forma segura.

✅ Corrigido com construtores nas três classes (Cliente, Pedido, PedidoOnline).

2. Falta de Encapsulamento Funcional
O método exibirDadosCliente estava sendo usado como setter, o que é um uso incorreto para um método que deveria apenas exibir dados.

Além disso, não havia métodos para exibir o pedido nem o pedido online.

✅ Corrigido com métodos:

exibirDadosCliente()

exibirDadosPedidos()

exibirPedidoCliente()
Cada um com responsabilidade única, respeitando o princípio da coesão.

3. Composição entre classes não implementada
A relação 1:1 entre Pedido e Cliente não foi implementada corretamente. Faltava a composição de objetos.

✅ Corrigido com a inclusão de um atributo Cliente cliente dentro da classe Pedido, passado via construtor.

4. Herança mal aplicada
A classe PedidoOnline herda Pedido, mas no original essa herança não é funcional. Não há uso dos atributos/métodos herdados.

✅ Corrigido com herança pública e reutilização do método da classe base (exibirDadosPedidos()), seguindo o princípio de reuso de código via herança.

5. Organização das responsabilidades
No original, as responsabilidades estavam confusas ou ausentes. A exibição dos dados era feita fora de contexto, e os métodos não estavam distribuídos corretamente.

✅ Corrigido com:

Cada classe tendo seu próprio método de exibição.

Respeito ao princípio de responsabilidade única.

*/
