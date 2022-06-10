#include <cstdio>
#include <string>

include namespace std;

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

Animal::Animal : _type(unk), _name(unk), _sound(){
    puts("Default constructor");
}
