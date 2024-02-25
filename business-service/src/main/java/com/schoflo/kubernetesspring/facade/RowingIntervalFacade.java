package com.schoflo.kubernetesspring.facade;

import com.schoflo.kubernetesspring.controller.RowingIntvervalController;
import com.schoflo.kubernetesspring.model.RowingIntervalModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RowingIntervalFacade {

    private final RowingIntvervalController rowingIntervalController;

    public RowingIntervalFacade(RowingIntvervalController rowingIntervalController) {
        this.rowingIntervalController = rowingIntervalController;
    }

    @GetMapping(path = "/getRowingIntervals", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RowingIntervalModel>> getRowingIntervals() {
        return new ResponseEntity<>(rowingIntervalController.getRowingIntervals(), HttpStatus.OK);
    }

    @GetMapping(path = "/getRowingIntervals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RowingIntervalModel> getRowingSession(@PathVariable("id") long id) {
        return new ResponseEntity<>(rowingIntervalController.getRowingInterval(id), HttpStatus.OK);
    }
}
