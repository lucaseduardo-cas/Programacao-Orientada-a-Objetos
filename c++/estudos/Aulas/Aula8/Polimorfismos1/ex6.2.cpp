#include <iostream>
#include <cmath>
#include <string>

using namespace std;

#ifndef M_PI
#define M_PI (3.14159265358979323846)
#endif

class Ponto {
private:
    double _x, _y;

public:
    Ponto(double x = 0, double y = 0) : _x(x), _y(y) {}

    double getX() const { return _x; }
    double getY() const { return _y; }
};

class Figura {
private:
    string _cor;

public:
    Figura(string cor) : _cor(cor) {}

    string getCor() {
        return this->_cor;
    }

    virtual double getArea() = 0;
    virtual double getPerimetro() = 0;

    virtual ~Figura() {}
};

class Circunferencia : public Figura {
private:
    Ponto _centro;
    double _raio;

public:
    Circunferencia(string cor, Ponto centro, double raio)
        : Figura(cor), _centro(centro), _raio(raio) {}

    double getArea() override {
        return M_PI * pow(this->_raio, 2);
    }

    double getPerimetro() override {
        return 2 * M_PI * this->_raio;
    }
};

int main() {
    Ponto centro(5, 5);
    Circunferencia c("preto", centro, 5);
    cout << c.getArea() << endl;
    cout << c.getPerimetro() << endl;
    return 0;
}
