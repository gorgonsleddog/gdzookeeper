package com.generaldynamics.animals;

import com.generaldynamics.habitats.Habitat;

public class Tiger extends Animal {
    public Tiger(final String name) {
        super(name);
        this.withHabitat(Habitat.AIR_BREATHER);
    }
}
