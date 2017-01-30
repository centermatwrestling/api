package com.centermat.api.repositories;

import com.centermat.api.model.TeamRecord;
import com.centermat.api.model.Wrestler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRecordRepository extends JpaRepository<TeamRecord,UUID> {
}
