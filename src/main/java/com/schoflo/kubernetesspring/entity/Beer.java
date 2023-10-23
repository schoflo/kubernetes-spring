package com.schoflo.kubernetesspring.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beer {

    @Id
    @GeneratedValue
    private String name;
    private String brewery;
    private double alcohol;
}