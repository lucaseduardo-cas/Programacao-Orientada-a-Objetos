/*
g++ -g -o poo4 poo4.cpp
gdb ./poo4
break main
run
next
print (variavel)
gdb info variables

Corrigir a prova e colocar para rodar junto com o gdb

2) Suponha que num sistema de informa��es para registros de vev�culos automotores, o objeto Veiculo n�o possa existir sem o objeto Motor. Ainda, nesse recorte do modelo, existem o objeto Motocicleta e o objeto Carro. Construa um diagrama de classes, definindo atributos, m�todos e relacionamentos para as classes, cujos objetos supracitados foram inst�nciados. JUSTIFIQUE SUA RESPOSTA! Em seguida, utilizando a linguagem de programa��o C++, mostre o programa. JUSTIFIQUE SUA RESPOSTA!

Justificativa:

Justificativa c�digo:
- Veiculo, motor, carro e motocicleta se tornam classes;
- Veiculo tem um motor obrigat�rio e motor tem um ve�culo obrigat�rio;
- Carro e Motocicleta herdam ve�culo;
- exibirVeiculo mostra dados do veiculo;

Justificativa diagrama de classes:
- Ve�culo � a classe prim�ria;
- Carro e motocicleta s�o classes secund�rias que herdam da classe ve�culo.
- Motor � essencial e estar� como atributo em ve�culo

Representa��o diagrama de classes:
Veiculo (+ motor:Motor, + marca:string, + modelo), exibir() void; 1 ----- 1 Motor (+ tipo: string, + potencia int), exibir() void;
Carro (- chasi), exibir(void) ------> Veiculo
Motocicleta (+ cor), exibir(void) ------> Veiculo
*/

#include <iostream>
#include <string>
using namespace std;

// Classe Motor
class Motor {
public:
    string tipo;
    int potencia;

    Motor(string tipo, int potencia) : tipo(tipo), potencia(potencia) {}

    void exibir() {
        cout << "Tipo: " << tipo << ", Pot�ncia: " << potencia << " cv" << endl;
    }
};

// Classe Veiculo
class Veiculo {
public:
    Motor motor;
    string marca;
    string modelo;

    Veiculo(string marca, string modelo, string tipoMotor, int potenciaMotor)
        : marca(marca), modelo(modelo), motor(tipoMotor, potenciaMotor) {}

    void exibirVeiculo() {
        cout << "Marca: " << marca << ", Modelo: " << modelo << endl;
        motor.exibir();
    }
};

// Classe Carro derivada de Veiculo
class Carro : public Veiculo {
private:
    string chassi;

public:
    Carro(string chassi, string marca, string modelo, string tipoMotor, int potenciaMotor)
        : Veiculo(marca, modelo, tipoMotor, potenciaMotor), chassi(chassi) {}

    void exibirCarro() {
        exibirVeiculo();
        cout << "Chassi: " << chassi << endl;
    }
};

// Classe Motocicleta derivada de Veiculo
class Motocicleta : public Veiculo {
public:
    string cor;

    Motocicleta(string cor, string marca, string modelo, string tipoMotor, int potenciaMotor)
        : Veiculo(marca, modelo, tipoMotor, potenciaMotor), cor(cor) {}

    void exibirMotocicleta() {
        exibirVeiculo();
        cout << "Cor: " << cor << endl;
    }
};

// Fun��o principal
int main() {
    string tipo = "Moto";  // Altere para "Moto" para testar a outra condi��o

    if (tipo == "Carro") {
        Carro car("12345", "Honda", "Civic", "Gasolina", 130);
        car.exibirCarro();
    } else if (tipo == "Moto") {
        Motocicleta mot("Vermelha", "Yamaha", "Fazer", "Gasolina", 21);
        mot.exibirMotocicleta();
    }

    return 0;
}



/*
/*
C�digo da prova:

Justificativa c�digo:
- Veiculo, motor, carro e motocicleta se tornam classes;
- Veiculo tem um motor obrigat�rio e motor tem um ve�culo obrigat�rio;
- Carro e Motocicleta herdam ve�culo;
- exibirVeiculo mostra dados do veiculo;

Justificativa diagrama de classes:
- Ve�culo � a classe prim�ria;
- Carro e motocicleta s�o classes secund�rias que herdam da classe ve�culo.
- Motor � essencial e estar� como atributo em ve�culo

Veiculo
*/
/*
#include <iostream>

class Veiculo {
public:
    motor Motor;
    std::string marca;
    std::string modelo;

    void exibirVeiculo() {
        std cout << "Marca: " << mcarca << "modelo: " << modelo << "tipo: " << tipo << "potencia" << potencia;
        motor.exibir();
    }
};

class Motor {
public:
    std::string tipo;
    std::int potencia;
    Motor (string tipo, int potencia: tipo(tipo)): potencia (potencia) {}
    void exibir();
};

class Carro:class Viculo {
private:
    std::string chasi;
public:
    Carro:(string chasi, string marca, string modelo) {
        this -> "chasi" = chasi;
    }
};

class Motocicleta:class Veiculo {
public:
    std::string cor;
    void exibirCor() {
        cout (("Cor: ")) << cor;
    }
};

int main () {
    Veiculo vei = "Hoda", "Civic", "Carro", "130";
    if (tipo == "Carro")
        Carro car = "12345";
    else if (tipo = moto) {
        Moto mot = "vermelho";
    }

    veiculo.exibirVeiculo();
    return 0;
}

*/
