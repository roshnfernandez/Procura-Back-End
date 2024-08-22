package com.trintel.equipment.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.user.entities.CategoryEO;

public interface CategoryRepository extends JpaRepository<CategoryEO, String>{

}
