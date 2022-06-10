#include <iostream>

using namespace std;

int main(){
    cl c;
    c.setvalue(20);
    std::cout<<"Hello World"<<c.getvalue();
    return 0;
}

class c1{
    int i=0;

public:
    void setvalue(const int &value){
        i = value;
    }

    int getvalue() const{
        return i;
    }

};

