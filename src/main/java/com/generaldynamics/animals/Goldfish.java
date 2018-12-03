package com.generaldynamics.animals;

import com.generaldynamics.habitats.Habitat;

public class Goldfish extends Animal {
    public Goldfish(final String name) {
        super(name);
        this.withHabitat(Habitat.WATER_BREATHER);
    }
}
