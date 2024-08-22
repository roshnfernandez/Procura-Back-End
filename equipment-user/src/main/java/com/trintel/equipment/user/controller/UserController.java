package com.trintel.equipment.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trintel.equipment.user.entities.EquipmentEO;
import com.trintel.equipment.user.entities.UsageLogEO;
import com.trintel.equipment.user.entities.UserEO;
import com.trintel.equipment.user.service.UserService;

@RestController
@RequestMapping("/trintel")
@CrossOrigin(origins="http://localhost:3000", allowedHeaders="*")
public class UserController {
	@Autowired
	UserService serviceRef;
	
	//Equipment
	@GetMapping("/equipment")
	public List<EquipmentEO> getAllEquipment(){
		return serviceRef.findAllEquipment();
	}
	@GetMapping("/equipment/{equipmentId}")
	public EquipmentEO getEquipmentById(@PathVariable String equipmentId){
		return serviceRef.findEquipmentById(equipmentId);
	}
	
	//Usage Logs
	@GetMapping("/logs")
	public List<UsageLogEO> getAllLogs(){
		return serviceRef.findAllLogs();
	}
	
	@GetMapping("/logs/{id}")
	public UsageLogEO getLogById(@PathVariable String id){
		return serviceRef.findLogById(id);
	}
	
	@PostMapping("/logs")
	public UsageLogEO addOrUpdateLog(@RequestBody UsageLogEO log){
		return serviceRef.addOrUpdateLog(log);
	}
	
	@GetMapping("/logs/user/{userId}")
	public UsageLogEO getActieLogByUserId(@PathVariable String userId){
		return serviceRef.findActiveLogByUserId(userId);
	}
	@GetMapping("/logs/all/user/{userId}")
	public List<UsageLogEO> getLogByUserId(@PathVariable String userId){
		return serviceRef.findLogByUserId(userId);
	}
	//User
	@GetMapping("/user/{id}")
	public UserEO getUserById(@PathVariable String id){
		return serviceRef.findUserById(id);
	}
}
