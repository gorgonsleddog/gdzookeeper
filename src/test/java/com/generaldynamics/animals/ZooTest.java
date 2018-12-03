package com.generaldynamics.animals;

import com.generaldynamics.zoo.Zoo;
import com.generaldynamics.zoo.Zookeeper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ZooTest {
    private Zoo zoo;

    @Before
    public void init() {
        zoo = new Zoo()
            .withAnimal(new Goldfish("Goldie"))
            .withAnimal(new SmallWhale("Flipper"))
            .withAnimal(new Tiger("Christopher Robin"))
            .withZookeeper(new Zookeeper("Hector"));
    }

    @Test
    public void canGetAnimalsByNameFromTheZoo() {
        Animal goldie = zoo.getAnimal("Goldie").orElse(null);
        assertNotNull("Did not get Goldie", goldie);
        assertEquals("Did not get Goldie", "Goldie", goldie.getName());
        assertEquals("Did not get Goldie", Goldfish.class, goldie.getClass());

        Animal flipper = zoo.getAnimal("Flipper").orElse(null);
        assertNotNull("Did not get Flipper", flipper);
        assertEquals("Did not get Flipper", "Flipper", flipper.getName());
        assertEquals("Did not get Flipper", SmallWhale.class, flipper.getClass());

        Animal tiger = zoo.getAnimal("Christopher Robin").orElse(null);
        assertNotNull("Did not get Christopher Robin", tiger);
        assertEquals("Did not get Christopher Robin", "Christopher Robin", tiger.getName());
        assertEquals("Did not get Christopher Robin", Tiger.class, tiger.getClass());
    }
}
