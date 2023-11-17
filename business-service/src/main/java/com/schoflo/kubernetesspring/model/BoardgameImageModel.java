package com.schoflo.kubernetesspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardgameImageModel {

    private long id;
    private String fileName;
    /**
     * Base64 enkodierte String des Bildes
     */
    private String file;
    private Long boardgameId;
}
