package com.generaldynamics.exceptions;

public class ZookeeperException extends Exception{
    public ZookeeperException(final String message) {
        super(String.format("Zookeeper exception: %s", message));
    }
}
