package com.schoflo.kubernetesspring.facade;

import com.schoflo.kubernetesspring.controller.BoardgameController;
import com.schoflo.kubernetesspring.model.BoardgameModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BoardgameFacade {

    private final BoardgameController boardgameController;

    public BoardgameFacade(BoardgameController boardgameController) {
        this.boardgameController = boardgameController;
    }


    @GetMapping(path = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @GetMapping(path = "/greeting-admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greetingAdmin(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @PostMapping(path = "/createBoardgame", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoardgameModel> createBoardgame(@RequestBody BoardgameModel boardgameModel) {
        return new ResponseEntity<>(boardgameController.createBoardgame(boardgameModel), HttpStatus.OK);
    }

    @GetMapping(path = "/getBoardgames", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BoardgameModel>> getBoardgames() {
        return new ResponseEntity<>(boardgameController.getBoardgames(), HttpStatus.OK);
    }

    @GetMapping(path = "/getBoardgame/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoardgameModel> getBoardgame(@PathVariable("id") long id) {
        return new ResponseEntity<>(boardgameController.getBoardgame(id), HttpStatus.OK);
    }
}
