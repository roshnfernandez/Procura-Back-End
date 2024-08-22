package com.trintel.equipment.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.provider.customrepository.CustomRepository;
import com.trintel.equipment.provider.entities.OrderItemEO;

public interface OrderItemRepository extends CustomRepository<OrderItemEO, String> {
}
