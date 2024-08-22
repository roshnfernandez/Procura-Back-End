package com.trintel.equipment.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.user.entities.CatalogEO;

public interface CatalogRepository extends JpaRepository<CatalogEO, String> {

}
