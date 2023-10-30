package com.schoflo.kubernetesspring.controller;

import com.schoflo.kubernetesspring.entity.Boardgame;
import com.schoflo.kubernetesspring.repository.BoardgameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
public class BoardgameController {

    @Autowired
    private BoardgameRepository boardgameRepo;

    public Boardgame createBoardgame(String name) {
        return boardgameRepo.save(Boardgame.builder().name(name).publisher("Shiro Games").price(59.99).build());
    }

    public List<Boardgame> getBoardgames() {
        return boardgameRepo.findAll();
    }

}
