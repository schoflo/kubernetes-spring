package com.schoflo.kubernetesspring.exception;

/**
 * Diese Exception wird geworfen, wenn keine Rudereinheit gefunden wurde.
 */
public class RowingSessionNotFoundException extends RuntimeException {


    public RowingSessionNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
