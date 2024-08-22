package com.trintel.equipment.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trintel.equipment.provider.entities.RoleEO;

public interface RoleRepository extends JpaRepository<RoleEO, String> {

}
