package com.generaldynamics.animals;

import com.generaldynamics.habitats.Habitat;

public class SmallWhale extends Animal {
    public SmallWhale(final String name) {
        super(name);
        this.withHabitat(Habitat.WATER_BREATHER);
        this.withHabitat(Habitat.AIR_BREATHER);
    }
}
