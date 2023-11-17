package com.schoflo.kubernetesspring.mapper;

import com.schoflo.kubernetesspring.entity.Boardgame;
import com.schoflo.kubernetesspring.entity.BoardgameImage;
import com.schoflo.kubernetesspring.model.BoardgameImageModel;
import com.schoflo.kubernetesspring.model.BoardgameModel;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardgameImageMapperTest {

    @Test
    void givenBoardgameImage_whenMappedToModel_ThenReturnBoardgameImageModel() throws IOException {
        //*** GIVEN ***
        Boardgame givenBoardgame = Boardgame.builder().id(1L).build();
        //TODO Pfad anpassen..
        File file = new File("C:/Entwicklung/intellij_projects/kubernetes-spring/business-service/src/test/resources/image/munchlax.png");

        BoardgameImage givenboardgameImage = BoardgameImage.builder().id(2L)
                .fileName(file.getName()).file(Files.readAllBytes(file.toPath()))
                .boardgame(givenBoardgame).build();

        givenBoardgame.setBoardgameImage(givenboardgameImage);

        //*** WHEN ****
        BoardgameImageModel actualModel = Mappers.getMapper(BoardgameImageMapper.class).toDto(givenboardgameImage);

        //*** THEN ****
        assertEquals(actualModel.getId(), givenboardgameImage.getId());
        assertEquals(actualModel.getFileName(), givenboardgameImage.getFileName());
        assertEquals(actualModel.getFile(), new String(Base64.getEncoder().encode(givenBoardgame.getBoardgameImage().getFile())));
        assertEquals(actualModel.getBoardgameId(), givenBoardgame.getBoardgameImage().getBoardgame().getId());
    }

    @Test
    void givenBoardgameImageModel_whenMappedToEntity_ThenReturnBoardgameImage() throws IOException {
        //*** GIVEN ***
        BoardgameModel givenBoardgameModel = BoardgameModel.builder().id(1L).build();
        //TODO Pfad anpassen..
        File file = new File("C:/Entwicklung/intellij_projects/kubernetes-spring/business-service/src/test/resources/image/munchlax.png");

        BoardgameImageModel givenboardgameImageModel = BoardgameImageModel.builder().id(2L)
                .fileName(file.getName()).file(new String(Base64.getEncoder().encode(Files.readAllBytes(file.toPath()))))
                .boardgameId(1L).build();

        givenBoardgameModel.setBoardgameImage(givenboardgameImageModel);

        //*** WHEN ****
        BoardgameImage actualBoardgameImage = Mappers.getMapper(BoardgameImageMapper.class).toEntity(givenboardgameImageModel);

        assertEquals(actualBoardgameImage.getId(), givenboardgameImageModel.getId());
        assertEquals(actualBoardgameImage.getFileName(), givenboardgameImageModel.getFileName());
        assertArrayEquals(actualBoardgameImage.getFile(), Base64.getDecoder().decode(givenBoardgameModel.getBoardgameImage().getFile()));
        assertEquals(actualBoardgameImage.getBoardgame().getId(), givenBoardgameModel.getBoardgameImage().getBoardgameId());
    }
}
