package com.trintel.equipment.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trintel.equipment.admin.customrepository.CustomRepository;
import com.trintel.equipment.admin.entities.UserEO;

public interface UserRepository extends CustomRepository<UserEO, String> {
	@Query("select ue from UserEO ue where ue.isActive = 'Y'")
	List<UserEO> findActiveUsers();
}
