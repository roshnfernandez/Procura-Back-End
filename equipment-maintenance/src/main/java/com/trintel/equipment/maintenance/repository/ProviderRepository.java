package com.trintel.equipment.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.maintenance.customrepository.CustomRepository;
import com.trintel.equipment.maintenance.entities.ProviderEO;

public interface ProviderRepository extends CustomRepository<ProviderEO, String> {

}
