package com.schoflo.kubernetesspring.facade;

import com.schoflo.kubernetesspring.controller.RowingController;
import com.schoflo.kubernetesspring.model.RowingSessionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
public class RowingFacade {

    private final RowingController rowingController;

    public RowingFacade(RowingController rowingController) {
        this.rowingController = rowingController;
    }

    @PostMapping(path = "/createRowingSession", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RowingSessionModel> createRowingSession(@RequestBody RowingSessionModel rowingSessionModel) {
        return new ResponseEntity<>(rowingController.createRowingSession(rowingSessionModel), HttpStatus.OK);
    }

    @GetMapping(path = "/getRowingSessions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RowingSessionModel>> getBoardgames() {
        return new ResponseEntity<>(rowingController.getRowingSessions(), HttpStatus.OK);
    }

    @GetMapping(path = "/getBoardgame/{id}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RowingSessionModel> getBoardgame(@PathVariable("id") long id) {
        return new ResponseEntity<>(rowingController.getRowingSession(id), HttpStatus.OK);
    }
}
