package com.generaldynamics.exceptions;

public class AnimalMissingException extends Exception {
    public AnimalMissingException(final String message) {
        super(String.format("Animal cannot be found: %s", message));
    }
}
