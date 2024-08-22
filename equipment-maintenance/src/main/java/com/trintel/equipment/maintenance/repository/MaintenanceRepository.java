package com.trintel.equipment.maintenance.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trintel.equipment.maintenance.customrepository.CustomRepository;
import com.trintel.equipment.maintenance.entities.MaintenanceHistoryEO;

public interface MaintenanceRepository extends CustomRepository<MaintenanceHistoryEO, String>{

	@Query("select me from MaintenanceHistoryEO me where me.equipment.providers.providerId = :providerId")
	List<MaintenanceHistoryEO> findByProviderId(@Param("providerId")String providerId);
	
	@Query("select me from MaintenanceHistoryEO me where me.equipment.equipmentId = :equipmentId")
	List<MaintenanceHistoryEO> findByEquipmentId(@Param("equipmentId")String equipmentId);
	
}
