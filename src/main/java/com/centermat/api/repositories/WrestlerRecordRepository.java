package com.centermat.api.repositories;

import com.centermat.api.model.TeamRecord;
import com.centermat.api.model.WrestlerRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WrestlerRecordRepository extends JpaRepository<WrestlerRecord,UUID> {
}
