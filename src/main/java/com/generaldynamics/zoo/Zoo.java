package com.generaldynamics.zoo;

import com.generaldynamics.animals.Animal;
import com.generaldynamics.exceptions.ZookeeperException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Zoo {
    private List<Animal> animals;

    private Zookeeper zookeeper;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public Zoo withZookeeper(Zookeeper zookeeper) {
        this.zookeeper = zookeeper;
        return this;
    }

    public Zoo withAnimal(Animal animal) {
        animals.add(animal);
        return this;
    }

    public Optional<Animal> getAnimal(final String name) {
        return animals.stream().filter(p -> p.getName().equals(name)).findFirst();
    }

    public Zookeeper getZookeeper() {
        return zookeeper;
    }

    public void getZooInfo() throws ZookeeperException {
        if (null == zookeeper) {
            throw new ZookeeperException("You require a zookeeper");
        }

        System.out.println(zookeeper.toString());
        for(Animal a : animals) {
            System.out.println(a.toString());
        }
    }
}
