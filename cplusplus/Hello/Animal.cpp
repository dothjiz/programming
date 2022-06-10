#include <cstdio>
#include <string>

using namespace std;

const string unk = "unknown";
const string clone_prefix = "clone-";

class Animal{
private:
    string _type="";
    string _name="";
    string _sound="";

public:
    Animal();//default constructor
    Animal(const string & type, const string & name, const string & sound);
    Animal(const Animal &);//copy constructor
    Animal & operator = (const Animal &);//copy operator
    ~Animal();//destructor

    void print() const;

};

Animal::Animal() : _type(unk), _name(unk), _sound(unk){
    puts("Default constructor");
}

Animal::Animal(const string &type, const string &name, const string &sound) : _type(type), _name(name), _sound(sound) {
    puts("Constructor with arguments");
}

Animal::Animal(const Animal &rhs){
    puts("Copy constructor");
    _type = clone_prefix + rhs._type;
    _name = rhs._name;
    _sound = rhs._sound;
}

Animal::~Animal(){
    printf("destructor: %s the %s\n", _name.c_str(), _type.c_str());
}

void Animal::print() const{
    printf("%s the %s says %s \n", _name.c_str(), _type.c_str(), _sound.c_str());
}

Animal &Animal::operator = (const Animal &rhs){
    puts("copy operator");
    if(this != &rhs){
        _type = clone_prefix + rhs._type;
        _name = rhs._name;
        _sound = rhs._sound;
    }
    return *this;
}

int main(){
    Animal a;
    a.print();

    Animal b("Cat", "Fluffy", "Meow");
    b.print();

    Animal c = b;
    c.print();

    a = c;
    a.print();

}
