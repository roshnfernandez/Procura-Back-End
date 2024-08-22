package com.trintel.equipment.provider.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trintel.equipment.provider.customrepository.CustomRepository;
import com.trintel.equipment.provider.entities.OrderEO;

public interface OrderRepository extends CustomRepository<OrderEO, String>{
	
	@Query("Select oe from OrderEO oe where oe.providers.users.userId = :userId")
	List<OrderEO> getOrdersByUserId(@Param("userId") String userId);
	
	@Query("select CONCAT(ROUND(AVG(trunc(oe.shippedOn) - trunc(oe.orderedOn)),2),'@#$',ROUND(AVG(trunc(oe.deliveredOn) - trunc(oe.shippedOn)),2)) FROM OrderEO oe where oe.shippedOn IS NOT NULL AND oe.providers.users.userId = :userId")
	String getOrderKPISByProviderId(@Param("userId") String userId);
}
