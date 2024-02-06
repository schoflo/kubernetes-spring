package com.schoflo.kubernetesspring.repository;

import com.schoflo.kubernetesspring.entity.rowing.RowingSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RowingSessionRepository extends JpaRepository<RowingSession, Long> {
}