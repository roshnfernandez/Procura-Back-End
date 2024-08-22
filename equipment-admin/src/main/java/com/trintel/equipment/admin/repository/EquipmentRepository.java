package com.trintel.equipment.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.admin.customrepository.CustomRepository;
import com.trintel.equipment.admin.entities.EquipmentEO;

public interface EquipmentRepository extends CustomRepository<EquipmentEO, String> {

}
