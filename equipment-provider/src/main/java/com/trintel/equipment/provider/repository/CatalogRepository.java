package com.trintel.equipment.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.provider.entities.CatalogEO;

public interface CatalogRepository extends JpaRepository<CatalogEO, String> {

}
