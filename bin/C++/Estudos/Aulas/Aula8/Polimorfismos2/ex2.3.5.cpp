// Exemplo link slide 12 pag 4

#include <iostream>

using namespace std;

class SpaceShip;
class ApolloSpacecraft;

class Asteroid {
  public:
    virtual void CollideWith(SpaceShip&) {
      cout << "Asteroid hit a SpaceShip" << endl;
    }
    virtual void CollideWith(ApolloSpacecraft&) {
      cout << "Asteroid hit an ApolloSpacecraft" << endl;
    }
};

class ExplodingAsteroid : public Asteroid {
  public:
    virtual void CollideWith(SpaceShip&) {
      cout << "ExplodingAsteroid hit a SpaceShip" << endl;
    }
    virtual void CollideWith(ApolloSpacecraft&) {
      cout << "ExplodingAsteroid hit an ApolloSpacecraft" << endl;
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
    virtual void CollideWith(Asteroid& inAsteroid) {
      inAsteroid.CollideWith(*this);
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

  Asteroid *otherExplodingAsteroid = new ExplodingAsteroid();
  otherExplodingAsteroid->CollideWith(theSpaceShip);
  otherExplodingAsteroid->CollideWith(theApolloSpacecraft);

  SpaceShip *otherApolloSpacecraft = new ApolloSpacecraft();
  theAsteroid.CollideWith(*otherApolloSpacecraft);
  otherExplodingAsteroid->CollideWith(*otherApolloSpacecraft);

  otherApolloSpacecraft->CollideWith(theAsteroid);
  otherApolloSpacecraft->CollideWith(*otherExplodingAsteroid);

  return 0;
}
