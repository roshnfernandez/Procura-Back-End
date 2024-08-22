package com.trintel.equipment.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.maintenance.entities.CategoryEO;

public interface CategoryRepository extends JpaRepository<CategoryEO, String>{

}
