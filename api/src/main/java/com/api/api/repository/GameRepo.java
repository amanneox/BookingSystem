package com.api.api.repository;

import com.api.api.model.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<GameModel, Long> {
}
