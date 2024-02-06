package com.schoflo.kubernetesspring.entity.rowing;

import com.schoflo.kubernetesspring.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@Entity
@Table(name = "rowing_workout")
public class RowingWorkout extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "strokes", nullable = false)
    private Integer strokes;

    @Column(name = "distance", nullable = false)
    private Integer distance;

    @Column(name = "time")
    private Time time;

    @Column(name = "calories")
    private Integer calories;

    @ManyToOne
    @JoinColumn(name = "rowing_session_id")
    private RowingSession rowingSession;
}