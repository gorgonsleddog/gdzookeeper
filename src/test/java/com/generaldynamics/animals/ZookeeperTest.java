package com.generaldynamics.animals;

import com.generaldynamics.exceptions.AnimalHabitatException;
import com.generaldynamics.exceptions.AnimalStateException;
import com.generaldynamics.habitats.Habitat;
import com.generaldynamics.zoo.Zookeeper;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class ZookeeperTest {
    @Test(expected = AnimalStateException.class)
    public void zookeeperCannotFeedSleepingAnimal() throws AnimalHabitatException,
        AnimalStateException {
        Animal animal = new Animal("Sleeping animal")
            .withSleeping(true);
        Zookeeper zookeeper = new Zookeeper("Hector");
        zookeeper.feedAnimal(animal);
    }

    @Test(expected = AnimalStateException.class)
    public void zookeeperCannotWaterSleepingAnimal() throws AnimalHabitatException,
        AnimalStateException {
        Animal animal = new Animal("Sleeping animal")
            .withHabitat(Habitat.AIR_BREATHER)
            .withSleeping(true);
        Zookeeper zookeeper = new Zookeeper("Hector");
        zookeeper.waterAnimal(animal);
    }

    @Test(expected = AnimalStateException.class)
    public void zookeeperCannotPutSleepingAnimalToBed() throws AnimalHabitatException,
        AnimalStateException {
        Animal animal = new Animal("Sleeping animal")
            .withHabitat(Habitat.AIR_BREATHER)
            .withSleeping(true);
        Zookeeper zookeeper = new Zookeeper("Hector");
        zookeeper.putAnimalToBed(animal);
    }

    @Test(expected = AnimalHabitatException.class)
    public void zookeeperCannotWaterAquaticAnimal() throws AnimalHabitatException,
        AnimalStateException {
        Animal animal = new Animal("Aquatic animal")
            .withHabitat(Habitat.WATER_BREATHER)
            .withSleeping(true);
        Zookeeper zookeeper = new Zookeeper("Hector");
        zookeeper.waterAnimal(animal);
    }

    @Test(expected = AnimalStateException.class)
    public void zookeeperCannotFeedFullAnimal() throws AnimalHabitatException,
        AnimalStateException {
        Animal animal = new Animal("Not hungry animal")
            .withHungry(false);
        Zookeeper zookeeper = new Zookeeper("Hector");
        zookeeper.feedAnimal(animal);
    };

    @Test(expected = AnimalStateException.class)
    public void zookeeperCannotWaterNonThirstyAnimal() throws AnimalHabitatException,
        AnimalStateException {
        Animal animal = new Animal("Not thirsty animal")
            .withHabitat(Habitat.AIR_BREATHER)
            .withThirsty(false);
        Zookeeper zookeeper = new Zookeeper("Hector");
        zookeeper.waterAnimal(animal);
    }

    @Test(expected = AnimalHabitatException.class)
    public void zookeeperCannotPutAquaticAnimaToBedl() throws AnimalHabitatException,
        AnimalStateException {
        Animal animal = new Animal("Aquatic animal")
            .withHabitat(Habitat.WATER_BREATHER)
            .withSleeping(false);
        Zookeeper zookeeper = new Zookeeper("Hector");
        zookeeper.putAnimalToBed(animal);
    }

    @Test
    public void zookeeperCanFeedHungryAnimal() throws AnimalHabitatException,
        AnimalStateException {
        Animal animal = new Animal("Hungry animal")
            .withHungry(true);
        Zookeeper zookeeper = new Zookeeper("Hector");
        zookeeper.feedAnimal(animal);
        assertFalse("Animal is still hungry", animal.isHungry());
    }

    @Test
    public void zookeeperCanWaterThirstyAnimal() throws AnimalHabitatException,
        AnimalStateException {
        Animal animal = new Animal("Thirsty animal")
            .withHabitat(Habitat.AIR_BREATHER)
            .withThirsty(true);
        Zookeeper zookeeper = new Zookeeper("Hector");
        zookeeper.waterAnimal(animal);
        assertFalse("Animal is still thirsty", animal.isThirsty());
    }

    @Test
    public void zookeeperCanPutAwakeAnimalToBed() throws AnimalHabitatException,
        AnimalStateException {
        Animal animal = new Animal("Sleepy animal")
            .withHabitat(Habitat.AIR_BREATHER)
            .withSleeping(false);
        Zookeeper zookeeper = new Zookeeper("Hector");
        zookeeper.putAnimalToBed(animal);
        assertFalse("Animal is still awake", animal.isSleeping());
    }
}
