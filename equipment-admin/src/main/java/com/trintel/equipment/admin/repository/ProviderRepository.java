package com.trintel.equipment.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.admin.customrepository.CustomRepository;
import com.trintel.equipment.admin.entities.ProviderEO;

public interface ProviderRepository extends CustomRepository<ProviderEO, String> {

}
