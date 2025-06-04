#include <iostream>
#include <string>

class SpaceShip;
class ApolloSpacecraft;

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
    virtual void CollideWith(SpaceShip& s) override {
        std::cout << "ExplodingAsteroid hit a SpaceShip" << std::endl;
    }
    virtual void CollideWith(ApolloSpacecraft& a) override {
        std::cout << "ExplodingAsteroid hit an ApolloSpacecraft" << std::endl;
    }
};

class SpaceShip {
public:
    virtual void CollideWith(Asteroid& inAsteroid) {
        inAsteroid.CollideWith(*this);
    }
};

class ApolloSpacecraft : public SpaceShip {
public:
    virtual void CollideWith(Asteroid& inAsteroid) override {
        inAsteroid.CollideWith(*this);
    }
};

int main() {
    Asteroid theAsteroid;
    Asteroid *otherExplodingAsteroid = new ExplodingAsteroid();
    SpaceShip *otherApolloSpacecraft = new ApolloSpacecraft();

    otherApolloSpacecraft->CollideWith(theAsteroid);
    otherApolloSpacecraft->CollideWith(*otherExplodingAsteroid);

    delete otherExplodingAsteroid;
    delete otherApolloSpacecraft;

    return 0;
}
