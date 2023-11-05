package com.schoflo.kubernetesspring.facade;

import com.schoflo.kubernetesspring.controller.BoardgameController;
import com.schoflo.kubernetesspring.model.BoardgameModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BoardgameFacade {

    @Autowired
    BoardgameController boardgameController;


    @GetMapping(path = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @GetMapping(path = "/greeting-admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greetingAdmin(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @PostMapping(path = "/createBoardgame", produces = MediaType.APPLICATION_JSON_VALUE)
    public BoardgameModel createBoardgame(@RequestBody BoardgameModel boardgameModel) {
        return boardgameController.createBoardgame(boardgameModel);
    }

    @GetMapping(path = "/getBoardgames", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BoardgameModel> getBoardgames() {
        return boardgameController.getBoardgames();
    }
}
