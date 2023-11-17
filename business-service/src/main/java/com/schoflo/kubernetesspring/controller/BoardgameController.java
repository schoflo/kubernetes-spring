package com.schoflo.kubernetesspring.controller;

import com.schoflo.kubernetesspring.entity.Boardgame;
import com.schoflo.kubernetesspring.entity.BoardgameImage;
import com.schoflo.kubernetesspring.exception.BoardgameImageCreationException;
import com.schoflo.kubernetesspring.exception.BoardgameNotFoundException;
import com.schoflo.kubernetesspring.mapper.BoardgameMapper;
import com.schoflo.kubernetesspring.model.BoardgameModel;
import com.schoflo.kubernetesspring.repository.BoardgameRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    public BoardgameModel createBoardgame(BoardgameModel boardgameModel, MultipartFile multipartFile) {
        Boardgame boardgame = boardgameMapper.toEntity(boardgameModel);

        BoardgameImage image;
        try {
            image = BoardgameImage.builder().fileName(multipartFile.getOriginalFilename())
                    .file(multipartFile.getBytes()).build();
        } catch (Exception e) {
            throw new BoardgameImageCreationException("Beim Speichern bes Bildes zum " +
                    "Brettspiel ist ein Fehler aufgetreten.");
        }
        boardgame.setBoardgameImage(image);

        return boardgameMapper.toDto(boardgameRepo.save(boardgame));
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

    /**
     * Gibt ein Brettspiel zurück
     *
     * @param id ID des Brettspiels
     * @return {@link Boardgame}
     * @throws BoardgameNotFoundException Wird geworfen wenn kein Brettspiel gefunden wurde.
     */
    public BoardgameModel getBoardgame(long id) throws BoardgameNotFoundException {
        return boardgameMapper.toDto(boardgameRepo.findById(id)
                .orElseThrow(() -> new BoardgameNotFoundException("Es wurde kein Brettspiel mit der ID " +
                        id + " gefunden")));
    }

}
