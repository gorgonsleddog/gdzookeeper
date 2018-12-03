package com.generaldynamics.exceptions;

public class AnimalHabitatException extends Exception {
    public AnimalHabitatException(final String message) {
        super(String.format("Animal habitat exception: %s", message));
    }
}
