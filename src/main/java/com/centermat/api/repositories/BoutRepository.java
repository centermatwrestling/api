package com.centermat.api.repositories;

import com.centermat.api.model.Bout;
import com.centermat.api.model.Wrestler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoutRepository extends JpaRepository<Bout,UUID> {
}
