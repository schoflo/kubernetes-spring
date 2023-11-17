package com.schoflo.kubernetesspring.repository;

import com.schoflo.kubernetesspring.entity.BoardgameImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardgameImageRepository extends JpaRepository<BoardgameImage, Long> {
}
