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
    Asteroid theAsteroid;
    Asteroid *otherExplodingAsteroid = new ExplodingAsteroid();
    SpaceShip *otherApolloSpacecraft = new ApolloSpacecraft();
    theAsteroid.CollideWith(*otherApolloSpacecraft);
    otherExplodingAsteroid->CollideWith(*otherApolloSpacecraft);

    return 0;
}
