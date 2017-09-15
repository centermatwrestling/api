package com.centermat.api.repositories;

import com.centermat.api.model.TeamRecord;
import com.centermat.api.model.Wrestler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TeamRecordRepository extends JpaRepository<TeamRecord,UUID> {
    Page<TeamRecord> findByTeamId(UUID teamId, Pageable pageable);

    List<TeamRecord> findByTeamIdInAndYear(UUID id, Integer year);
}
