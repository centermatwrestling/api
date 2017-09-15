package com.centermat.api.repositories;

import com.centermat.api.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team,UUID> {
    List<Team> findByLevelOfPlayIdOrConferenceId(UUID levelId,UUID conferenceId);
}
