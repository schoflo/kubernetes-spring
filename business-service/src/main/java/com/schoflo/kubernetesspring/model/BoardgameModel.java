package com.schoflo.kubernetesspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardgameModel {
    private long id;
    private String name;
    private String publisher;
    private String description;
    private double price;
    private double rating;
    private LocalDate releasedate;
    private byte[] image;
}
