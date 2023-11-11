package com.schoflo.kubernetesspring.controller;

import com.schoflo.kubernetesspring.entity.Boardgame;
import com.schoflo.kubernetesspring.exception.BoardgameNotFoundException;
import com.schoflo.kubernetesspring.repository.BoardgameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class BoardgameControllerTest {

    @Mock
    BoardgameRepository mockedBoardgameRepo;

    @Test
    void givenId_whenGetBoardgame_thenReturnBoardgame() {

        //*** GIVEN ***
        long expectedId = 1;
        Optional<Boardgame> boardgameOptional = Optional.of(Boardgame.builder().id(1).build());
        Mockito.when(mockedBoardgameRepo.findById(1L)).thenReturn(boardgameOptional);

        //*** WHEN ****
        Boardgame actualBoardgame = mockedBoardgameRepo.findById(expectedId)
                .orElseThrow(() -> new BoardgameNotFoundException(""));

        //*** THEN ****
        assertEquals(expectedId, actualBoardgame.getId());
    }

    @Test
    void givenNotExistingId_whenGetBoardgame_thenBoardgameNotFoundException() {

        //*** GIVEN ***
        long expectedId = 1;
        Optional<Boardgame> boardgameOptional = Optional.empty();
        Mockito.when(mockedBoardgameRepo.findById(1L)).thenReturn(boardgameOptional);

        //*** WHEN ****
        Optional<Boardgame> actualBoardgameOptional = mockedBoardgameRepo.findById(expectedId);

        //*** THEN ****
        assertThrows(BoardgameNotFoundException.class, () -> actualBoardgameOptional
                .orElseThrow(() -> new BoardgameNotFoundException("")));
    }
}
