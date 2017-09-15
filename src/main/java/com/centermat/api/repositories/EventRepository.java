package com.centermat.api.repositories;

import com.centermat.api.model.Bout;
import com.centermat.api.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event,UUID> {

    List<Event> findByTeamIdsAndYear(UUID teamId, Integer year);

    Set<Event> findByTeamIdsInAndYear(Collection<UUID> teamId, Integer year);
}
