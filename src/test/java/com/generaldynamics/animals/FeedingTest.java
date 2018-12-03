package com.generaldynamics.animals;

import com.generaldynamics.exceptions.AnimalHabitatException;
import com.generaldynamics.exceptions.AnimalStateException;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class FeedingTest {
    @Test(expected = AnimalStateException.class)
    public void feedingSleepingAnimalShouldThrowAnimalStateException() throws AnimalStateException,
        AnimalHabitatException {
        Animal animal = new Animal("Sleeping animal")
            .withSleeping(true);
        animal.feedAnimal();
    }

    @Test(expected = AnimalStateException.class)
    public void feedingNotHungryAnimalShouldThrowAnimalStateException() throws
        AnimalStateException,
        AnimalHabitatException {

        Animal animal = new Animal("Fully-fed animal")
            .withHungry(false);
        animal.feedAnimal();
    }

    @Test
    public void feedingHungryAnimalShouldFullyFeedAnimal() throws
        AnimalStateException,
        AnimalHabitatException {
        Animal animal = new Animal("Fully-fed animal")
            .withHungry(true);
        animal.feedAnimal();
        assertFalse("Animal was not fully-fed", animal.isHungry());
    }
}
