package com.schoflo.kubernetesspring.controller;


import com.schoflo.kubernetesspring.exception.RowingSessionNotFoundException;
import com.schoflo.kubernetesspring.mapper.RowingIntervalMapper;
import com.schoflo.kubernetesspring.model.RowingIntervalModel;
import com.schoflo.kubernetesspring.repository.RowingIntervalRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RowingIntvervalController {

    private final RowingIntervalRepository rowingIntervalRepo;
    private final RowingIntervalMapper rowingIntervalMapper;

    public RowingIntvervalController(RowingIntervalRepository rowingIntervalRepo, RowingIntervalMapper rowingIntervalMapper) {
        this.rowingIntervalRepo = rowingIntervalRepo;
        this.rowingIntervalMapper = rowingIntervalMapper;
    }


    public List<RowingIntervalModel> getRowingIntervals() {
        return rowingIntervalRepo.findAll().stream().map(rowingIntervalMapper::toDto).toList();
    }

    public RowingIntervalModel getRowingInterval(long id) {
        return rowingIntervalMapper.toDto(rowingIntervalRepo.findById(id)
                .orElseThrow(() -> new RowingSessionNotFoundException("Es wurde kein RowingInterval mit der ID " +
                        id + " gefunden")));
    }
}
