package com.schoflo.kubernetesspring.facade;

import com.schoflo.kubernetesspring.controller.BoardgameController;
import com.schoflo.kubernetesspring.entity.Boardgame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
public class BoardgameFacade {

    @Autowired
    BoardgameController boardgameController;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @GetMapping("/greeting-admin")
    public String greetingAdmin(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @PostMapping("/createBoardgame")
    public Boardgame createBoardgame(@RequestParam(name = "name", required = false, defaultValue = "Northgard") String name) {
        return boardgameController.createBoardgame(name);
    }

    @GetMapping("/getBoardgames")
    public List<Boardgame> getBoardgames() {
        return boardgameController.getBoardgames();
    }
}
