package com.carloguemes.polymorphism;

import com.carloguemes.polymorphism.Animal;
import com.carloguemes.polymorphism.Dog;

public class Polymorphism {

    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        myAnimal.eat();

        Dog myDog = new Dog();
        myDog.eat();

        Cat myCat = new Cat();
        myCat.eat();
    }
}

/*
Polymorphism is one you have a method in a child class like eat method in the dog class overrides a method in its
parent class, so now we are doing the same thing in a different form. Same thing in many forms, polymorphism

There's another way of polymorphism in java and that is method overloading

M

 */
