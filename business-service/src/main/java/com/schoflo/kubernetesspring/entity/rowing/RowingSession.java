package com.schoflo.kubernetesspring.entity.rowing;

import com.schoflo.kubernetesspring.entity.BaseEntity;
import com.schoflo.kubernetesspring.util.RowingMode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Duration;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "rowing_session")
public class RowingSession extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "rowing_mode")
    private RowingMode rowingMode;

    @ManyToOne
    @JoinColumn(name = "rowing_interval_id")
    private RowingInterval rowingInterval;

    @Column(name = "workout_time", nullable = false)
    private Duration workoutTime;

    @Column(name = "strokes", nullable = false)
    private Integer strokes;

    @Column(name = "distance", nullable = false)
    private Integer distance;


}