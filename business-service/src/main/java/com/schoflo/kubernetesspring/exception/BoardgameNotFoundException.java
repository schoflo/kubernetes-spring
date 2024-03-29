package com.schoflo.kubernetesspring.exception;

/**
 * Diese Exception wird geworfen, wenn kein Brettspiel gefunden wurde.
 */
public class BoardgameNotFoundException extends NotFoundException {
    public BoardgameNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
