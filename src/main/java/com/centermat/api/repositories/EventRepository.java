package com.centermat.api.repositories;

import com.centermat.api.model.Bout;
import com.centermat.api.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event,UUID> {
}
