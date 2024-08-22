package com.trintel.equipment.maintenance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.trintel.equipment.maintenance.customrepository.CustomRepository;
import com.trintel.equipment.maintenance.entities.EquipmentEO;

public interface EquipmentRepository extends CustomRepository<EquipmentEO, String> {
	@Query("select oe from EquipmentEO oe where oe.providers.providerId = :providerId")
	List<EquipmentEO> findByProviderId(@Param("providerId") String providerId);
	@Query("select oe from EquipmentEO oe where oe.orderNum = :orderNum")
	List<EquipmentEO> findByOrderNum(@Param("orderNum") String orderNum);
	@Query("select oe from EquipmentEO oe where oe.status IN ('FUNCTIONAL','BROKEN_DOWN') AND oe.equipmentId NOT IN (select me.equipment.equipmentId from MaintenanceHistoryEO me where me.status IN ('INITIATED','SCHEDULED') )")
	List<EquipmentEO> findMaintenanceEligibleEquipment();
	@Query(nativeQuery=true, value="SELECT equipment_kpi() FROM dual")
	String getEquipmentKPI();
	@Query(nativeQuery=true, value="select equipment_by_id_kpi(:equipmentId) from DUAL")
	String getEquipmentKPIById(@Param("equipmentId") String equipmentId);
}
