package com.schoflo.kubernetesspring.entity.rowing;

import com.schoflo.kubernetesspring.entity.BaseEntity;
import com.schoflo.kubernetesspring.util.RowingMode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
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

    @OneToMany(mappedBy = "rowingSession", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<RowingWorkout> rowingWorkouts = new LinkedHashSet<>();

}