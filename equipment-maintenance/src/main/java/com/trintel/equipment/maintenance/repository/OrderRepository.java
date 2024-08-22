package com.trintel.equipment.maintenance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trintel.equipment.maintenance.customrepository.CustomRepository;
import com.trintel.equipment.maintenance.entities.EquipmentEO;
import com.trintel.equipment.maintenance.entities.OrderEO;

public interface OrderRepository extends CustomRepository<OrderEO, String>{

	@Query("select oe from OrderEO oe where oe.providers.providerId = :providerId")
	List<OrderEO> findByProviderId(@Param("providerId") String providerId);

	@Query(nativeQuery=true, value="SELECT orders_kpi() FROM dual")
	String getOrdersKPI();
}
