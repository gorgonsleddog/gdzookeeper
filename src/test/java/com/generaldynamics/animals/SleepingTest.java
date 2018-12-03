package com.generaldynamics.animals;

import com.generaldynamics.exceptions.AnimalHabitatException;
import com.generaldynamics.exceptions.AnimalStateException;
import com.generaldynamics.habitats.Habitat;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class SleepingTest {
    @Test(expected = AnimalStateException.class)
    public void puttingToSleepSleepingAnimalShouldThrowAnimalStateException() throws AnimalStateException,
        AnimalHabitatException {
        Animal animal = new Animal("Sleeping animal")
            .withHabitat(Habitat.AIR_BREATHER)
            .withSleeping(true);
        animal.putAnimalToBed();
    }

    @Test(expected = AnimalHabitatException.class)
    public void puttingAquaticAnimalToSleepShouldThrowAnimalHabitatException() throws
        AnimalStateException,
        AnimalHabitatException {

        Animal animal = new Animal("Fully-fed animal")
            .withHabitat(Habitat.WATER_BREATHER);
        animal.putAnimalToBed();
    }

    @Test
    public void puttingAwakeAnimalToBedShouldPutAnimalToSleep() throws
        AnimalStateException,
        AnimalHabitatException {
        Animal animal = new Animal("Fully-fed animal")
            .withHabitat(Habitat.AIR_BREATHER);
        animal.putAnimalToBed();
        assertFalse("Animal is not sleeping", animal.isSleeping());
    }
}
