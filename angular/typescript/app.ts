let aString = "doth"

interface PersonInterface {
    name: string;
    age: number;
}

let Dayo: PersonInterface = {
    name: "Dayo",
    age: 32
}

function logging(msg: string) {
    console.log(msg);
}

class Person implements PersonInterface {

    name: string;
    age: number;

    constructor(name: string, age: number){
        this.name = name;
        this.age = age;
    }

    greet(): string{
        return `Hi, my name is ${this.name} and I am ${this.age}.`
    }

}


const nameInput = document.querySelector('#name') as HTMLInputElement;
const ageInput = document.querySelector('#age') as HTMLInputElement;
const formInput = document.querySelector('form')!;
const greetings = document.querySelector('.greetings') as HTMLDivElement;

formInput.addEventListener('submit', (e)=>{
    e.preventDefault();

    const person = new Person(nameInput.value, ageInput.valueAsNumber);
    greetings.innerHTML = person.greet();
    formInput.reset();
});

let john = new Person("John", 2)

logging(john.greet());