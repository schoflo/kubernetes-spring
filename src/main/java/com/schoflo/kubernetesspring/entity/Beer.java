package com.schoflo.kubernetesspring.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Beer {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String brewery;
    private double alcohol;
}