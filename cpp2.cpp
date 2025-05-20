#include <iostream>

using namespace std;

int main () {
    //TIPO NOME;
    //TIPO NOME = VALOR;

    int vidas=0; //10, 25
    char letra='B'; //'B'
    char letras[5]={'A','B','C', 'D', 'E'}; //A,B,C,D,E,F,G,H,I,j,K,L,M,N,O,P,Q,R,S,T,U,V,W,Y,Z...
    double decimal=2.54321; //2.4999999999
    float decimal2=2.5; //2.5
    bool vivo=true; //true = verdadeiro | false = falso (0/1) - testes condicionais
    string nome="Bruno"; //"Bruno"

    cout << "Vidas: " << vidas << endl;
    cout << "Letra: " << letra << endl;
    cout << "Letras: ";
    for (int i=0; i<5; i++) {
        cout << letras[i];
        if (i < 4) {
            cout << ", ";
        }
    }
    cout << endl;
    cout << "Decimal: " << decimal << endl;
    cout << "Decimal2: " << decimal2 << endl;
    cout << "Vivo: " << vivo << endl;
    cout << "Nome: " << nome << endl;
    cout << endl;

    // Entrada de dados
    cout << "Digite o número de vidas: ";
    cin >> vidas; // Entrada de dados;
    cout << "Digite uma letra: ";
    cin >> letra;

    cout << "Vidas: " << vidas << endl;
    cout << "Letra: " << letra << endl;

    return 0;
}
