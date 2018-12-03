package com.generaldynamics.exceptions;

public class AnimalStateException extends Exception {
    public AnimalStateException(final String message) {
        super(String.format("Animal habitat exception: %s", message));
    }
}
