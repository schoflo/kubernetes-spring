package com.schoflo.kubernetesspring.exception;

/**
 * Diese Exception wird geworfen, wenn kein Brettspiel gefunden wurde.
 */
public class BoardgameNotFoundException extends RuntimeException {
    public BoardgameNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
