package com.trintel.equipment.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trintel.equipment.user.customrepository.CustomRepository;
import com.trintel.equipment.user.entities.UsageLogEO;

public interface UsageLogRepository extends CustomRepository<UsageLogEO, String> {

	@Query("SELECT ule FROM UsageLogEO ule WHERE ule.users.userId = :userId AND ule.hoursUsed IS NULL")
	UsageLogEO findActiveLogByUserId(@Param("userId") String userId);
	@Query("SELECT ule FROM UsageLogEO ule WHERE ule.users.userId = :userId")
	List<UsageLogEO> findLogByUserId(@Param("userId") String userId);
}
