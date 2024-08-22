package com.trintel.equipment.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trintel.equipment.admin.customrepository.CustomRepository;
import com.trintel.equipment.admin.entities.CatalogEO;

public interface CatalogRepository extends CustomRepository<CatalogEO, String> {
	@Query("select ce from CatalogEO ce where ce.isActive = 'Y'")
	List<CatalogEO> findActiveProducts();
}
