package com.centermat.api.repositories;

import com.centermat.api.model.Event;
import com.centermat.api.model.EventMatchup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventMatchupRepository extends JpaRepository<EventMatchup,UUID> {
}
