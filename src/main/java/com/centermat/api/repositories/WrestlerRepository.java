package com.centermat.api.repositories;

import com.centermat.api.model.Team;
import com.centermat.api.model.Wrestler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WrestlerRepository extends JpaRepository<Wrestler,UUID> {
}
