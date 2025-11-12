#include <iostream>
#include <list>
using namespace std;

double square(double a) {
    cout << "Square of double: " << a << endl;
    return a * a;
}

int square(int a) {
    cout << "Square of int: " << a << endl;
    return a * a;
}

int main() {
    square(1);
    square(1.0);
    square('a');

    return 0;
}
