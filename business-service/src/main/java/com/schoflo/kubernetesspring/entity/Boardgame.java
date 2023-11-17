package com.schoflo.kubernetesspring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Boardgame extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String publisher;
    private String description;
    private double price;
    private double rating;
    private LocalDate releasedate;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "boardgame_id", foreignKey = @ForeignKey(name = "FK_BOARDGAME_boardgame_id_BOARDGAMEIMAGE_ID"))
    private BoardgameImage boardgameImage;

}