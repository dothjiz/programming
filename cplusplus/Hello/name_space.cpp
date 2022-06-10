#include <cstdio>
#include <string>
#include <iostream>

using namespace std;

namespace bw{
    const std::string prefix = " (bw::string): ";

    class string{
        std::string _s = "";
        string();

    public:
        string(const std::string &s): _s(prefix+s){}
        const char *c_str() const {return _s.c_str();}
        operator std::string & (){return _s;}
        operator const char *() const {return _s.c_str();}
    };
};

class num{
private:
    int _value = 0;
public:
    num(int value): _value(value){}
    void setvalue(int value){_value=value;}
    int getvalue() const {return _value;}

    num & operator ++ ();
    num operator ++ (int);

    num & operator -- ();
    num operator -- (int);
};

num & num::operator ++(){
    cout<<"pre-increment: \n";
    _value += 1;
    return *this;
}

num num::operator ++(int){
    cout<<"post-increment: \n";
    num temp = *this;
    _value += 1;
    return temp;
}

num & num::operator --(){
    cout<<"pre-decrement: \n";
    _value -= 1;
    return *this;
}

num num::operator --(int){
    num temp = *this;
    _value -+ 1;
    return temp;//cannot return reference to a temp value on a stack
}

ostream & operator << (ostream & o, const num & n){
    return o << (n.getvalue());
}


class C{
private:
    int _a = 0;
    int _b = 0;
    int _c = 0;
public:
    C(int i=0);
    ~C();
    int a(){return _a;}
    int b(){return _b;}
    int c(){return _c;}

};

C::C(int i): _a(i), _b(i+1), _c(i+2){
    puts("c constructor");
}

C::~C(){
    puts("c destructor");
}

//functor
class MultBy{
private:
    int mult = 1;
public:
    MultBy(int t);
    int operator () (int n) const;
};

MultBy::MultBy(int t): mult(t){}

//overload the function operator [()] to do multiplication
int MultBy::operator () (int n) const {
    return mult * n;
}

int main(){
    const std::string s = "this is a string";
    std::puts(s.c_str());

    const bw::string s2(s);
    std::puts(s2);

    num nos(20);
    cout<<++nos;

    try{
        C *c = new C;
        printf("c: %d, %d, %d \n", c->a(), c->b(), c->c());
        delete c;
    }catch(std::bad_alloc & ba){
        printf("new c failed: %s\n", ba.what());
        return 1;
    }

    //if no try catch
    C *c1 = new(nothrow) C;

    if(c1 == nullptr){
        puts("new cl failed");
        return 1;
    }
    printf("c1: %d, %d, %d \n", c1->a(), c1->b(), c1->c());
    delete c1;


    MultBy multiply4(4);
    printf("multiply 4 by 5: %d", multiply4(5));

    return 0;
}
