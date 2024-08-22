package com.trintel.equipment.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.maintenance.customrepository.CustomRepository;
import com.trintel.equipment.maintenance.entities.OrderItemEO;

public interface OrderItemRepository extends CustomRepository<OrderItemEO, String> {
}
