package com.trintel.equipment.user.service;

import java.util.List;

import com.trintel.equipment.user.entities.EquipmentEO;
import com.trintel.equipment.user.entities.UsageLogEO;
import com.trintel.equipment.user.entities.UserEO;

public interface UserService {
	//Equipment
	public List<EquipmentEO> findAllEquipment();
	public EquipmentEO findEquipmentById(String equipmentId);
	
	//Usage Logs
	public List<UsageLogEO> findAllLogs();
	public UsageLogEO findLogById(String id);
	public UsageLogEO addOrUpdateLog(UsageLogEO log);
	public UsageLogEO findActiveLogByUserId(String userId);
	public List<UsageLogEO> findLogByUserId(String userId);
	
	//User
	public UserEO findUserById(String id);
}
