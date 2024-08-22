package com.trintel.equipment.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.provider.entities.CategoryEO;

public interface CategoryRepository extends JpaRepository<CategoryEO, String>{

}
