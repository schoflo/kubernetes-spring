package com.schoflo.kubernetesspring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlingController {

    @ExceptionHandler(BoardgameNotFoundException.class)
    public ResponseEntity<ErrorMessage> boardgameNotFoundException(BoardgameNotFoundException ex) {
        ErrorMessage message = new ErrorMessage(ex.getMessage());
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BoardgameImageCreationException.class)
    public ResponseEntity<ErrorMessage> boardgameImageCreationException(BoardgameImageCreationException ex) {
        ErrorMessage message = new ErrorMessage(ex.getMessage());
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
