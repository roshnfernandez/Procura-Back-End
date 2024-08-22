package com.trintel.equipment.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trintel.equipment.admin.customrepository.CustomRepository;
import com.trintel.equipment.admin.entities.OrderEO;

public interface OrderRepository extends CustomRepository<OrderEO, String>{

	@Query("select oe from OrderEO oe where oe.providers.providerId = :providerId")
	List<OrderEO> findByProviderId(@Param("providerId") String providerId);
}
