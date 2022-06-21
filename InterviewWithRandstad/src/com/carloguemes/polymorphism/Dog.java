package com.carloguemes.polymorphism;

import com.carloguemes.polymorphism.Animal;

public class Dog extends Animal {
    private int breed;

    public void eat() {
        System.out.println("chomp, chomp");
    }

    //method overloading
    public void eat(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            System.out.println("chomp, chomp");
        }
    }

    public int getBreed() {
        return breed;
    }

    public void setBreed(int breed) {
        this.breed = breed;
    }
}
