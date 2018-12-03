package com.generaldynamics.animals;

import com.generaldynamics.exceptions.AnimalHabitatException;
import com.generaldynamics.exceptions.AnimalStateException;
import com.generaldynamics.habitats.Habitat;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class WateringTest {
    @Test(expected = AnimalStateException.class)
    public void wateringSleepingAnimalShouldThrowAnimalStateException() throws AnimalStateException,
        AnimalHabitatException {
        Animal animal = new Animal("Sleeping animal")
            .withHabitat(Habitat.AIR_BREATHER)
            .withSleeping(true);
        animal.waterAnimal();
    }

    @Test(expected = AnimalStateException.class)
    public void wateringNonThirstyAnimalShouldThrowAnimalStateException() throws
        AnimalStateException,
        AnimalHabitatException {

        Animal animal = new Animal("Non-thirsty animal")
            .withHabitat(Habitat.AIR_BREATHER)
            .withThirsty(false);
        animal.waterAnimal();
    }

    @Test(expected = AnimalHabitatException.class)
    public void wateringAquaticAnimalShouldThrowAnimalHabitatException() throws
        AnimalStateException,
        AnimalHabitatException {

        Animal animal = new Animal("Aquatic animal")
            .withThirsty(false)
            .withHabitat(Habitat.WATER_BREATHER);
        animal.waterAnimal();
    }

    @Test
    public void wateringThirstyAnimalShouldFullyWaterAnimal() throws
        AnimalStateException,
        AnimalHabitatException {
        Animal animal = new Animal("Thirsty animal")
            .withHabitat(Habitat.AIR_BREATHER)
            .withThirsty(true);
        animal.waterAnimal();
        assertFalse("Animal is still thirsty", animal.isThirsty());
    }
}
