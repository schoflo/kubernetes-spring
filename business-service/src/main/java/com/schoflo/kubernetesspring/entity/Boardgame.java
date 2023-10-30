package com.schoflo.kubernetesspring.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Boardgame {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String publisher;
    private String description;
    private double price;
    @Lob
    @Column
    private byte[] image;
}