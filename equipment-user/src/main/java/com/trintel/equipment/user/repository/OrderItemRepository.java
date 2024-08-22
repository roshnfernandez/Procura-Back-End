package com.trintel.equipment.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.user.customrepository.CustomRepository;
import com.trintel.equipment.user.entities.OrderItemEO;

public interface OrderItemRepository extends CustomRepository<OrderItemEO, String> {
}
