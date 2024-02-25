package com.schoflo.kubernetesspring.exception;

/**
 * Diese Exception wird geworfen, wenn kein Ruderintervall gefunden wurde.
 */
public class RowingIntervalNotFoundException extends RuntimeException {


    public RowingIntervalNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
