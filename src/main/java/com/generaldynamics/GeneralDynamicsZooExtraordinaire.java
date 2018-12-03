package com.generaldynamics;

import com.generaldynamics.animals.Animal;
import com.generaldynamics.animals.Goldfish;
import com.generaldynamics.animals.SmallWhale;
import com.generaldynamics.animals.Tiger;
import com.generaldynamics.exceptions.AnimalHabitatException;
import com.generaldynamics.exceptions.AnimalMissingException;
import com.generaldynamics.exceptions.AnimalStateException;
import com.generaldynamics.exceptions.ZookeeperException;
import com.generaldynamics.zoo.Zoo;
import com.generaldynamics.zoo.Zookeeper;

import java.util.Scanner;

public class GeneralDynamicsZooExtraordinaire {
    private static Zoo generalDynamicsZoo;
    private static Scanner scanner = new Scanner(System.in);

    private static void welcome() {
        System.out.println("Welcome to generalDynamicsZoo.");
    }

    private static void listOptions() {
        System.out.println("Commands are: feed, water, putToBed, setHungry, setThirsty, setSleeping, info, exit");
    }

    private static Animal getAnimal() throws AnimalMissingException {
        System.out.println("Enter animal's name");
        String name = scanner.next();
        Animal animal = generalDynamicsZoo.getAnimal(name).orElse(null);

        if(null == animal) {
            throw new AnimalMissingException(name);
        }

        return animal;
    }

    private static void processOption(final String option, final Zookeeper zookeeper)
        throws AnimalMissingException, AnimalHabitatException, AnimalStateException,
        ZookeeperException {

        String sanitizedOption = option.toLowerCase();

        switch(sanitizedOption) {
            case "feed":
                zookeeper.feedAnimal(getAnimal());
                break;
            case "water":
                zookeeper.waterAnimal(getAnimal());
                break;
            case "puttobed":
                zookeeper.putAnimalToBed(getAnimal());
                break;
            case "sethungry":
                getAnimal().setHungry();
                break;
            case "setthirsty":
                getAnimal().setThirsty();
                break;
            case "setsleeping":
                getAnimal().setSleeping();
                break;
            case "info":
                generalDynamicsZoo.getZooInfo();;
                break;
            case "exit":
                // Do nothing
                break;
            default:
                System.err.println(String.format("Unknown command: %s", option));
        }
    }

    public static void main(String[] args)
        throws ZookeeperException, AnimalStateException, AnimalHabitatException,
        AnimalMissingException {
         generalDynamicsZoo = new Zoo()
            .withZookeeper(new Zookeeper("Hector"))
            .withAnimal(new SmallWhale("Flipper"))
            .withAnimal(new Goldfish("Goldie"))
            .withAnimal(new Tiger("Christopher Robin"));

        welcome();
        generalDynamicsZoo.getZooInfo();
        listOptions();

        String option = "";

        do {
            try {
                System.out.print("Enter command: ");
                option = scanner.next();
                processOption(option, generalDynamicsZoo.getZookeeper());
            } catch(ZookeeperException | AnimalStateException | AnimalHabitatException |
                AnimalMissingException e) {
                System.err.println(e);
                System.out.print("Enter command: ");
            }
        } while(!option.equals("exit"));

    }
}
