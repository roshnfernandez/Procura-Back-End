package com.trintel.equipment.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.maintenance.entities.RoleEO;

public interface RoleRepository extends JpaRepository<RoleEO, String> {

}
