// Exemplo 2
#include <iostream>
#include <typeinfo>

class Base {
public:
    virtual void dummy() {};
};

class Derived_A : public Base { };

class Derived_B : public Base { };

int main() {
    Base* b1 = new Derived_A();
    Base* b2 = new Base();

    try {
        Derived_A& d1 = dynamic_cast<Derived_A&>(*b1);
        std::cout << "Conversao OK" << std::endl;
        Derived_A& d2 = dynamic_cast<Derived_A&>(*b2);
        std::cout << "Conversao OK" << std::endl;
    } catch (std::bad_cast& e) { // Usado std::bad_cast
        std::cout << e.what() << std::endl;
    }

    delete b1;
    delete b2;

    return 0;
}
