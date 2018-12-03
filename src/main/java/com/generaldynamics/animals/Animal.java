package com.generaldynamics.animals;

import com.generaldynamics.exceptions.AnimalHabitatException;
import com.generaldynamics.exceptions.AnimalStateException;
import com.generaldynamics.habitats.Habitat;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private boolean isHungry;

    private boolean isSleeping;

    private final String name;

    private boolean isThirsty;

    private List<Habitat> habitats;

    Animal(final String name) {
        this.name = name;
        this.isHungry = false;
        this.isSleeping = false;
        this.isThirsty = false;
        habitats = new ArrayList<>();
    }

    /* Setters to test state transitions */
    public void setHungry() {
        this.isHungry = true;
    }

    public void setSleeping() {
        this.isSleeping = true;
    }

    public void setThirsty() throws AnimalHabitatException {
        if(!canBeThirsty()) {
            throw new AnimalHabitatException(String.format("%s cannot be thirsty", name));
        }
        this.isThirsty = true;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public boolean isThirsty() {
        return canBeThirsty() && isThirsty;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public String getName() {
        return name;
    }

    boolean canBeThirsty() {
        for(Habitat h : habitats) {
            if(h.canBeThirsty()) {
                return true;
            }
        }
        return false;
    }

    boolean canBePutToBed() {
        for(Habitat h : habitats) {
            if(h.canBePutToBed()) {
                return true;
            }
        }
        return false;
    }

    public void feedAnimal() throws AnimalHabitatException, AnimalStateException {
        if(!isHungry) {
            throw new AnimalStateException(String.format("%s is not hungry.", name));
        }

        if(isSleeping) {
            throw new AnimalStateException(String.format("%s is sleeping.", name));
        }

        setHungry(false);
    }

    public void waterAnimal() throws AnimalHabitatException, AnimalStateException {
        if(!canBeThirsty()) {
            throw new AnimalHabitatException(String.format("%s cannot be thirsty", name));
        }

        if(!isThirsty) {
            throw new AnimalStateException(String.format("%s is not thirsty.", name));
        }

        if(isSleeping) {
            throw new AnimalStateException(String.format("%s is sleeping.", name));
        }

        setThirsty(false);
    }

    public void putAnimalToBed() throws AnimalHabitatException, AnimalStateException {
        if(!canBePutToBed()) {
            throw new AnimalHabitatException(String.format("%s cannot be put to bed", name));
        }

        if(isSleeping) {
            throw new AnimalStateException(String.format("%s is already asleep", name));
        }
    }

    Animal withHabitat(Habitat habitat) {
        this.habitats.add(habitat);
        return this;
    }

    Animal withSleeping(final boolean isSleeping) {
        this.isSleeping = isSleeping;
        return this;
    }

    Animal withHungry(final boolean isHungry) {
        this.isHungry = isHungry;
        return this;
    }

    Animal withThirsty(final boolean isThirsty) {
        this.isThirsty = isThirsty;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nHungry: %s\nThirsty: %s\nIs Sleeping: %s\n",
            name, isHungry, isThirsty, isSleeping);
    }

    private void setHungry(final boolean isHungry) {
        this.isHungry = isHungry;
    }

    private void setThirsty(final boolean isThirsty) {
        this.isThirsty = isThirsty;
    }
}
