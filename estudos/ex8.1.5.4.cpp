/*
*AD-HOC-COERÇÃO
- Widening conversions (promoção)
    - Conversão para outro tipo que possui maior
    (ou mesmo) bits de armazenamento

    bool -> char -> short int -> int -> unsigned int -> long ->
    unsigned long long -> float -> double -> long double
- Não deixe na mão do compilador!
*/

#include <iostream>
#include <list>
using namespace std;

class A { };

class B : public A { };

class C {
public:
    void m(A a) {
        cout << "C::m(A)" << endl;
    }
    void m(B b) {
        cout << "C::m(B)" << endl;
    }
};

