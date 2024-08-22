package com.trintel.equipment.provider.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trintel.equipment.provider.customrepository.CustomRepository;
import com.trintel.equipment.provider.entities.MaintenanceHistoryEO;

public interface MaintenanceRepository extends CustomRepository<MaintenanceHistoryEO, String>{
	
	@Query("select me from MaintenanceHistoryEO me where me.equipment.equipmentId = :equipmentId AND me.status IN ('SCHEDULED','STARTED')")
	MaintenanceHistoryEO findActiveMaintenanceByEquipmentId(@Param("equipmentId")String equipmentId);
	
	@Query("select me from MaintenanceHistoryEO me where me.technicianEmail = :techEmail")
	List<MaintenanceHistoryEO> findByTechEmail(@Param("techEmail")String techEmail);
	
	@Query("select me from MaintenanceHistoryEO me where me.equipment.providers.users.userId = :providerId")
	List<MaintenanceHistoryEO> findByProviderId(@Param("providerId")String providerId);
	
	@Query("select me from MaintenanceHistoryEO me where me.equipment.equipmentId = :equipmentId")
	List<MaintenanceHistoryEO> findByEquipmentId(@Param("equipmentId")String equipmentId);
}
