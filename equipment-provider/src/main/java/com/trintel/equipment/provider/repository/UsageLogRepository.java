package com.trintel.equipment.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.provider.entities.UsageLogEO;

public interface UsageLogRepository extends JpaRepository<UsageLogEO, String> {

}
