package com.trintel.equipment.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.user.entities.RoleEO;

public interface RoleRepository extends JpaRepository<RoleEO, String> {

}
