package com.schoflo.kubernetesspring.controller;

import com.schoflo.kubernetesspring.entity.Boardgame;
import com.schoflo.kubernetesspring.mapper.BoardgameMapper;
import com.schoflo.kubernetesspring.model.BoardgameModel;
import com.schoflo.kubernetesspring.repository.BoardgameRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BoardgameController {

    // Field Injection not recommended (https://www.baeldung.com/java-spring-field-injection-cons)
    private final BoardgameRepository boardgameRepo;
    private final BoardgameMapper boardgameMapper;

    public BoardgameController(BoardgameRepository boardgameRepo, BoardgameMapper boardgameMapper) {
        this.boardgameRepo = boardgameRepo;
        this.boardgameMapper = boardgameMapper;
    }

    public BoardgameModel createBoardgame(BoardgameModel boardgameModel) {
        Boardgame boardgame = boardgameRepo.save(boardgameMapper.toEntity(boardgameModel));
        return boardgameMapper.toDto(boardgame);
    }

    /**
     * Gibt eine Liste aller gespeicherten Brettspiele zurück
     *
     * @return Liste von {@link Boardgame}
     */
    public List<BoardgameModel> getBoardgames() {
        List<Boardgame> boardgames = boardgameRepo.findAll();
        return boardgames.stream()
                .map(boardgameMapper::toDto)
                .toList();
    }

}
