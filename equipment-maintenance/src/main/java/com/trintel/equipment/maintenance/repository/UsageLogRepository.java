package com.trintel.equipment.maintenance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trintel.equipment.maintenance.entities.UsageLogEO;

public interface UsageLogRepository extends JpaRepository<UsageLogEO, String> {
	
	@Query("select ule from UsageLogEO ule where ule.equipment.equipmentId = :equipmentId")
	List<UsageLogEO> findByEquipmentId(@Param("equipmentId") String equipmentId);
}
