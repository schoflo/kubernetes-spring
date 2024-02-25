package com.schoflo.kubernetesspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

    /**
     * Datum an dem der Datensatz erstellt wurde.
     */
    @CreationTimestamp
    private Date createdAt;
    /**
     * Datum an dem der Datensatz das letzte mal geändert wurde.
     */
    @UpdateTimestamp
    public Date lastUpdatedAt;
}
