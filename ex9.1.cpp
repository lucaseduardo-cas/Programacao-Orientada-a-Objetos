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
