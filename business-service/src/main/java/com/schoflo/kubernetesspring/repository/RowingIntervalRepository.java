package com.schoflo.kubernetesspring.repository;

import com.schoflo.kubernetesspring.entity.rowing.RowingInterval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RowingIntervalRepository extends JpaRepository<RowingInterval, Long> {
}