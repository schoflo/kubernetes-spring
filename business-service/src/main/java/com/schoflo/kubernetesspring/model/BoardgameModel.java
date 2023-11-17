package com.schoflo.kubernetesspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardgameModel {
    private Long id;
    private String name;
    private String publisher;
    private String description;
    private double price;
    private double rating;
    private LocalDate releasedate;
    private BoardgameImageModel boardgameImage;
}
