package com.schoflo.kubernetesspring.facade;

import com.schoflo.kubernetesspring.controller.RowingController;
import com.schoflo.kubernetesspring.model.RowingSessionModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rowing")
public class RowingFacade {

    private final RowingController rowingController;

    public RowingFacade(RowingController rowingController) {
        this.rowingController = rowingController;
    }

    @PostMapping(path = "/createRowingSession", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RowingSessionModel> createRowingSession(@RequestBody RowingSessionModel rowingSessionModel) {
        return new ResponseEntity<>(rowingController.createRowingSession(rowingSessionModel), HttpStatus.OK);
    }

    @GetMapping(path = "/getRowingSessions", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<RowingSessionModel>> getRowingSessions() {
        return new ResponseEntity<>(rowingController.getRowingSessions(), HttpStatus.OK);
    }

    @Operation(summary = "Get a Rowingsession by it's ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the RowingSession",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RowingSessionModel.class))}),
            @ApiResponse(responseCode = "404", description = "RowingSession with given ID not found",
                    content = @Content)})
    @GetMapping(path = "/getRowingSession/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RowingSessionModel> getRowingSession(@PathVariable("id") long id) {
        return new ResponseEntity<>(rowingController.getRowingSession(id), HttpStatus.OK);
    }
}
