package com.schoflo.kubernetesspring.controller;


import com.schoflo.kubernetesspring.entity.rowing.RowingSession;
import com.schoflo.kubernetesspring.exception.RowingSessionNotFoundException;
import com.schoflo.kubernetesspring.mapper.RowingSessionMapper;
import com.schoflo.kubernetesspring.model.RowingSessionModel;
import com.schoflo.kubernetesspring.repository.RowingSessionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RowingController {

    private final RowingSessionRepository rowingSessionRepo;
    private final RowingSessionMapper rowingSessionMapper;

    public RowingController(RowingSessionRepository rowingSessionRepo, RowingSessionMapper rowingSessionMapper) {
        this.rowingSessionRepo = rowingSessionRepo;
        this.rowingSessionMapper = rowingSessionMapper;
    }

    public RowingSessionModel createRowingSession(RowingSessionModel rowingSessionModel) {
        RowingSession entity = rowingSessionMapper.toEntity(rowingSessionModel);
        return rowingSessionMapper.toDto(rowingSessionRepo.save(entity));
    }

    public List<RowingSessionModel> getRowingSessions() {
        return rowingSessionRepo.findAll().stream().map(rowingSessionMapper::toDto).toList();
    }

    public RowingSessionModel getRowingSession(long id) {
        return rowingSessionMapper.toDto(rowingSessionRepo.findById(id)
                .orElseThrow(() -> new RowingSessionNotFoundException("Es wurde keine RowingSession mit der ID " +
                        id + " gefunden")));
    }
}
