package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animalList = new ArrayList<>();
        ArrayList<Dog> dogList = new ArrayList<>();
        ArrayList<Cat> catList = new ArrayList<>();

        Dog dog = new Dog("Fido", "golden retriever");

        Cat cat = new Cat("Pancake");

        animalList.add(dog);
        animalList.add(cat);

        for (Animal animal : animalList) {
            if (animal instanceof Dog) {
                Dog currentDog = (Dog) animal;
                System.out.println("Dog: " + currentDog.getName() + ", Breed: " + currentDog.getBreed());
            } else if (animal instanceof Cat) {
                Cat currentCat = (Cat) animal;
                System.out.println("Cat: " + currentCat.getName());
            }
        }
    }
}