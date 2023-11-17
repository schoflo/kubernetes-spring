package com.schoflo.kubernetesspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BoardgameImage extends BaseEntity {

    @Id
    @GeneratedValue
    private long id;
    private String fileName;
    @Lob
    private byte[] file;
    @OneToOne(mappedBy = "boardgameImage", cascade = CascadeType.ALL)
    Boardgame boardgame;
}
