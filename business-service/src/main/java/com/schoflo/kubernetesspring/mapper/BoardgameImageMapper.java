package com.schoflo.kubernetesspring.mapper;

import com.schoflo.kubernetesspring.entity.BoardgameImage;
import com.schoflo.kubernetesspring.model.BoardgameImageModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;

@Mapper(componentModel = "spring")
public abstract class BoardgameImageMapper {

    @Mapping(source = "boardgame.id", target = "boardgameId")
    @Mapping(source = "file", target = "file", qualifiedByName = "mapByteArrayToBase64String")
    public abstract BoardgameImageModel toDto(BoardgameImage boardgameImage);

    @Mapping(source = "boardgameId", target = "boardgame.id")
    @Mapping(source = "file", target = "file", qualifiedByName = "mapBase64StringToByteArray")
    public abstract BoardgameImage toEntity(BoardgameImageModel boardgameImageModel);

    @Named("mapByteArrayToBase64String")
    public String mapByteArrayToBase64String(byte[] file) {
        return new String(Base64.getEncoder().encode(file));
    }

    @Named("mapBase64StringToByteArray")
    public byte[] mapBase64StringToByteArray(String file) {
        return Base64.getDecoder().decode(file);
    }

}
