package com.centermat.api.repositories;

import com.centermat.api.model.CompetitionLevel;
import com.centermat.api.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompetitionLevelRepository extends JpaRepository<CompetitionLevel,UUID> {
}
