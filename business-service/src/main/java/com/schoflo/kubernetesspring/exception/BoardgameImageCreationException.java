package com.schoflo.kubernetesspring.exception;

public class BoardgameImageCreationException extends RuntimeException {
    public BoardgameImageCreationException(String errorMessage) {
        super(errorMessage);
    }
}
