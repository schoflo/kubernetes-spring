package com.schoflo.kubernetesspring.repository;

import com.schoflo.kubernetesspring.entity.Boardgame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardgameRepository extends JpaRepository<Boardgame, Long> {
}
