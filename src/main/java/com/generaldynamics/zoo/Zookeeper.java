package com.generaldynamics.zoo;

import com.generaldynamics.animals.Animal;
import com.generaldynamics.exceptions.AnimalHabitatException;
import com.generaldynamics.exceptions.AnimalStateException;

public class Zookeeper {
    public final String name;

    public Zookeeper(final String name) {
        this.name = name;
    }

    public void feedAnimal(final Animal animal) throws AnimalHabitatException, AnimalStateException {
        animal.feedAnimal();
    }

    public void waterAnimal(final Animal animal) throws AnimalHabitatException, AnimalStateException {
        animal.waterAnimal();
    }

    public void putAnimalToBed(final Animal animal) throws AnimalHabitatException, AnimalStateException {
        animal.putAnimalToBed();
    }

    @Override
    public String toString() {
        return String.format("Zookeeper: %s\n", name);
    }
}
