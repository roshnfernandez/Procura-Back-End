package com.trintel.equipment.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trintel.equipment.user.entities.EquipmentEO;
import com.trintel.equipment.user.entities.UsageLogEO;
import com.trintel.equipment.user.entities.UserEO;
import com.trintel.equipment.user.repository.EquipmentRepository;
import com.trintel.equipment.user.repository.UsageLogRepository;
import com.trintel.equipment.user.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	EquipmentRepository equipRep;
	@Autowired
	UsageLogRepository logRep;
	@Autowired
	UserRepository userRep;
	
	@Override
	public List<EquipmentEO> findAllEquipment() {
		// TODO Auto-generated method stub
		return equipRep.findAll();
	}

	@Override
	public EquipmentEO findEquipmentById(String equipmentId) {
		// TODO Auto-generated method stub
		return equipRep.findById(equipmentId).get();
	}

	@Override
	public List<UsageLogEO> findAllLogs() {
		// TODO Auto-generated method stub
		return logRep.findAll();
	}

	@Override
	public UsageLogEO findLogById(String id) {
		// TODO Auto-generated method stub
		return logRep.findById(id).get();
	}

	@Override
	public UsageLogEO addOrUpdateLog(UsageLogEO log) {
		// TODO Auto-generated method stub
		if(log.getLogId().equals(""))
			return logRep.saveWithPkReturn(log, "logId");
		return logRep.save(log);
	}

	@Override
	public UserEO findUserById(String id) {
		// TODO Auto-generated method stub
		return userRep.findById(id).get();
	}

	@Override
	public UsageLogEO findActiveLogByUserId(String userId) {
		// TODO Auto-generated method stub
		return logRep.findActiveLogByUserId(userId);
	}

	@Override
	public List<UsageLogEO> findLogByUserId(String userId) {
		// TODO Auto-generated method stub
		return logRep.findLogByUserId(userId);
	}
}
