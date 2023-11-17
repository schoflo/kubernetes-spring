package com.schoflo.kubernetesspring.mapper;

import com.schoflo.kubernetesspring.entity.Boardgame;
import com.schoflo.kubernetesspring.model.BoardgameModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = BoardgameImageMapper.class)
public interface BoardgameMapper {

    BoardgameModel toDto(Boardgame boardgame);

    Boardgame toEntity(BoardgameModel boardgameModel);
}
