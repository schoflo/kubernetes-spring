package com.schoflo.kubernetesspring.entity.rowing;

import com.schoflo.kubernetesspring.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * mbenennung der Variablennamen führt zu inkonsistenter Datenbank!
 */
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "rowing_interval")
public class RowingInterval extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Dauer der Ruhepausen in diesem Intervall. Angegeben in Sekunden
     */
    @Column(name = "rest_time", nullable = false)
    private Long restTime;

    /**
     * Anzahl der Wiederholungen in diesem Intervall.
     * Eine Wiederholung besteht aus 1x {@link RowingInterval#singleDistance} + 1x {@link RowingInterval#restTime}.
     */
    @Column(name = "repetitions", nullable = false)
    private Integer repetitions;

    /**
     * Strecke die in einer Wiederholung des Intervalls zurückgelegt wurde.
     */
    @Column(name = "single_distance", nullable = false)
    private Integer singleDistance;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "rowing_interval_id")
    private Set<RowingSession> rowingSessions = new LinkedHashSet<>();

}