package com.trintel.equipment.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.user.customrepository.CustomRepository;
import com.trintel.equipment.user.entities.ProviderEO;

public interface ProviderRepository extends CustomRepository<ProviderEO, String> {

}
