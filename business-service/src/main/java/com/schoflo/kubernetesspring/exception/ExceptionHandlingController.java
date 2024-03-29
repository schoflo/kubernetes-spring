package com.schoflo.kubernetesspring.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlingController {

    @ExceptionHandler({BoardgameNotFoundException.class, RowingSessionNotFoundException.class,
            RowingIntervalNotFoundException.class})
    public ResponseEntity<NotFoundException> notFoundException(NotFoundException ex) {
        NotFoundException message = new NotFoundException(ex.getMessage());
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BoardgameImageCreationException.class)
    public ResponseEntity<BoardgameImageCreationException> boardgameImageCreationException(BoardgameImageCreationException ex) {
        BoardgameImageCreationException message = new BoardgameImageCreationException(ex.getMessage());
        log.debug(ex.getMessage(), ex);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
