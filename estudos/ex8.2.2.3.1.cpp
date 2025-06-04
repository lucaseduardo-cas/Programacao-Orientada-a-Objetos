/*
Double Dispatch

- Problema
    - Sobrecarga → Static Dispatch
    - Sobrescrita (virtual) → Dynamic Dispatch
- Double Dispatch
    - Mecanismo que despacha uma chamada de
    função para diferentes funções concretas
    dependendo dos runtime types dos objetos
    - Receptor / Argumentos
*/

#include <iostream>
#include <string>

class SpaceShip {};

class ApolloSpacecraft : public SpaceShip {};

class Asteroid {
public:
    virtual void CollideWith(SpaceShip& s) {
        std::cout << "Asteroid hit a SpaceShip" << std::endl;
    }
    virtual void CollideWith(ApolloSpacecraft& a) {
        std::cout << "Asteroid hit an ApolloSpacecraft" << std::endl;
    }
};

class ExplodingAsteroid : public Asteroid {
public:
    virtual void CollideWith(SpaceShip& s) override { // Adicionado 'override'
        std::cout << "ExplodingAsteroid hit a SpaceShip" << std::endl;
    }
    virtual void CollideWith(ApolloSpacecraft& a) override { // Adicionado 'override'
        std::cout << "ExplodingAsteroid hit an ApolloSpacecraft" << std::endl;
    }
};

int main() {
    SpaceShip theSpaceShip;
    ApolloSpacecraft theApolloSpacecraft;
    Asteroid theAsteroid;
    theAsteroid.CollideWith(theSpaceShip);
    theAsteroid.CollideWith(theApolloSpacecraft);
    ExplodingAsteroid theExplodingAsteroid;
    theExplodingAsteroid.CollideWith(theSpaceShip);
    theExplodingAsteroid.CollideWith(theApolloSpacecraft);

    return 0;
}
