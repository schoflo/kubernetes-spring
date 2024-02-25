package com.schoflo.kubernetesspring.entity.rowing;

import com.schoflo.kubernetesspring.entity.BaseEntity;
import com.schoflo.kubernetesspring.util.RowingMode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Diese Entität beschreibt alle Eigenschaften einer Rudereinheit. Für Session mit Intervallen wird
 * trotzdem die Gesamtzahl der Strokes und Distances angegeben.
 * Die genauere Klassifizierung erfolgt über {@link RowingInterval}
 */
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

    /**
     * {@link RowingMode} der Rudereinheit.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "rowing_mode")
    private RowingMode rowingMode;

    /**
     * {@link RowingInterval} der Ruderession.
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    private RowingInterval rowingInterval;

    /**
     * Die Gesamtdauer des Workouts. Wird in Millisekunden angegeben, da die meisten Trainingscomputer
     * auch Millisekunden nachverfolgen.
     */
    @Column(name = "workout_time", nullable = false)
    private Long workoutTime;

    /**
     * Tag an dem das Workout stattgefunden hat.
     */
    @Column(name = "workout_date", nullable = false)
    private LocalDate workoutDate;

    /**
     * Anzahl der Gesamtruderschläge in dieser Rudereinheit.
     */
    @Column(name = "strokes", nullable = false)
    private Integer strokes;

    /**
     * Gesamtdistanz, die in dieser Rudereinheit zurückgelegt wurde.
     */
    @Column(name = "distance", nullable = false)
    private Integer distance;

    /**
     * Anzahl der Kalorien, die in dieser Einheit verbraucht wurden.
     */
    @Column(name = "calories", nullable = false)
    private Integer calories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowingSession that = (RowingSession) o;
        return Objects.equals(id, that.id) && rowingMode == that.rowingMode && Objects.equals(rowingInterval, that.rowingInterval) && Objects.equals(workoutTime, that.workoutTime) && Objects.equals(workoutDate, that.workoutDate) && Objects.equals(strokes, that.strokes) && Objects.equals(distance, that.distance) && Objects.equals(calories, that.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rowingMode, rowingInterval, workoutTime, workoutDate, strokes, distance, calories);
    }
}