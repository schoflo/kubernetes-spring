package com.schoflo.kubernetesspring.exception;

/**
 * Diese Exception wird geworfen, wenn kein Ruderintervall gefunden wurde.
 */
public class RowingIntervalNotFoundException extends NotFoundException {


    public RowingIntervalNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
