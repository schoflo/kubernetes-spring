package com.schoflo.kubernetesspring.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
    private long id;
    private String name;
    private String publisher;
    private String description;
    private double price;
    private double rating;
    private LocalDate releasedate;
    @Lob
    private byte[] image;
}