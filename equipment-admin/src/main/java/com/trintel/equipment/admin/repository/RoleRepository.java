package com.trintel.equipment.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.admin.entities.RoleEO;

public interface RoleRepository extends JpaRepository<RoleEO, String> {

}
