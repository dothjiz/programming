#include <iostream>
#include <cstdio>

using namespace std;

class Count{
private:
    int _value=0;
    Count();
public:
    explicit Count(const int &);
    void setvalue(const int &);
    int getvalue() const;
};

Count::Count(const int &value): _value(value){}

void Count::setvalue(const int &value){
        _value = value;
    }

int Count::getvalue() const{
    return _value;
}

int main(){
    //Count cl='x'; explicit prevents xter conversion to int
    Count cl(20);
    cl.setvalue(20);
    std::cout<<"Hello World "<<cl.getvalue();
    return 0;
}


