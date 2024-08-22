package com.trintel.equipment.maintenance.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trintel.equipment.maintenance.customrepository.CustomRepository;
import com.trintel.equipment.maintenance.entities.UserEO;

public interface UserRepository extends CustomRepository<UserEO, String> {
	@Query("Select ue from UserEO ue where ue.email = :email AND ue.password = :password AND ue.isActive = 'Y' ")
	public UserEO authenticateUser(@Param("email") String email, @Param("password") String password);
}
