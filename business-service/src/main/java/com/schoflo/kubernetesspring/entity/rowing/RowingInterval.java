package com.schoflo.kubernetesspring.entity.rowing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "rowing_interval")
public class RowingInterval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @CreationTimestamp
    private Date createdAt;

    @Column(name = "rest_time", nullable = false)
    private Time restTime;

    @Column(name = "repetitions", nullable = false)
    private Integer repetitions;

    @Column(name = "single_distance", nullable = false)
    private Integer singleDistance;

}