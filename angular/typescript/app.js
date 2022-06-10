"use strict";
var aString = "doth";
var Dayo = {
    name: "Dayo",
    age: 32
};
function logging(msg) {
    console.log(msg);
}
var Person = /** @class */ (function () {
    function Person(name, age) {
        this.name = name;
        this.age = age;
    }
    Person.prototype.greet = function () {
        return "Hi, my name is " + this.name + " and I am " + this.age + ".";
    };
    return Person;
}());
var nameInput = document.querySelector('#name');
var ageInput = document.querySelector('#age');
var formInput = document.querySelector('form');
var greetings = document.querySelector('.greetings');
formInput.addEventListener('submit', function (e) {
    e.preventDefault();
    var person = new Person(nameInput.value, ageInput.valueAsNumber);
    greetings.innerHTML = person.greet();
    formInput.reset();
});
var john = new Person("John", 2);
logging(john.greet());
