package com.generaldynamics.animals;

import com.generaldynamics.habitats.Habitat;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class HabitatTest {
    @Test
    public void waterBreatherShouldNeverBeThirsty() {
        Animal animal = new Animal("Test aquatic animal")
            .withHabitat(Habitat.WATER_BREATHER);
        assertFalse("Aquatic animals should not get thirsty", animal.canBeThirsty());
    }

    @Test
    public void airBreatherCanBeThirsty() {
        Animal animal = new Animal("Test aquatic animal")
            .withHabitat(Habitat.AIR_BREATHER);
        assertTrue("Air breather should get thirsty", animal.canBeThirsty());
    }

    @Test
    public void airAndWaterBreatherCanBeThirsty() {
        Animal animal = new Animal("Test aquatic animal")
            .withHabitat(Habitat.WATER_BREATHER)
            .withHabitat(Habitat.AIR_BREATHER);
        assertTrue("Air/water breather should get thirsty", animal.canBeThirsty());
    }
}
