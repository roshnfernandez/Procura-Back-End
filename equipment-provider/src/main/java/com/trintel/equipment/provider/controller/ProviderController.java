package com.trintel.equipment.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trintel.equipment.provider.entities.EquipmentEO;
import com.trintel.equipment.provider.entities.MaintenanceHistoryEO;
import com.trintel.equipment.provider.entities.BillEO;
import com.trintel.equipment.provider.entities.OrderEO;
import com.trintel.equipment.provider.service.ProviderService;

@RestController
@RequestMapping("/trintel")
@CrossOrigin(origins="http://localhost:3000", allowedHeaders="*")
public class ProviderController {
	@Autowired
	private ProviderService serviceRef;

	// Orders
	@GetMapping("/orders")
	public List<OrderEO> getAllOrders() {
		return serviceRef.findAllOrder();
	}

	@GetMapping("/orders/{orderId}")
	public OrderEO getOrderById(@PathVariable String orderId) {
		return serviceRef.findOrderById(orderId);
	}
	@GetMapping("/orders/provider/{userId}")
	public List<OrderEO> getOrderByUserId(@PathVariable String userId) {
		return serviceRef.findByUserId(userId);
	}
	@PostMapping("/orders")
	public OrderEO addOrUpdateOrders(@RequestBody OrderEO order) {
		OrderEO res = serviceRef.addOrUpdateOrder(order);
		System.out.println(res);
		return res;
	}
	@GetMapping("/orders/kpi/{userId}")
	public String getOrderKPI(@PathVariable String userId) {
		return serviceRef.getOrderKPI(userId);
	}
	// Bills
	@GetMapping("/bills")
	public List<BillEO> getAllBills() {
		return serviceRef.findAllBills();
	}

	@GetMapping("/bills/{billNum}")
	public BillEO getBillById(@PathVariable String billNum) {
		return serviceRef.findBillById(billNum);
	}
	
	@PostMapping("/bills")
	public BillEO addOrUpdateBill(@RequestBody BillEO bill){
		return serviceRef.addOrUpdateBill(bill);
	}
	
	//Equipment
	@GetMapping("/equipment")
	public List<EquipmentEO> getAllEquipment(){
		return serviceRef.findAllEquipment();
	}
	@GetMapping("/equipment/{equipmentId}")
	public EquipmentEO getEquipmentById(@PathVariable String equipmentId){
		return serviceRef.findEquipmentById(equipmentId);
	}
	@PostMapping("/equipment")
	public EquipmentEO addOrUpdateEquipment(@RequestBody EquipmentEO equipment){
		return serviceRef.addOrUpdateEquipment(equipment);
	}
	@PostMapping("/equipment/addAll")
	public List<EquipmentEO> addAllEquipment(@RequestBody List<EquipmentEO> equipment){
		List<EquipmentEO> res = new ArrayList<>();
		for(EquipmentEO currEquipment: equipment){
			res.add(serviceRef.addOrUpdateEquipment(currEquipment));
		}
		return res;
	}
	
	//Maintenance
	@GetMapping("/maintenance")
	public List<MaintenanceHistoryEO> getAllMaintenance(){
		return serviceRef.findAllMaintenance();
	}
	@GetMapping("/maintenance/{id}")
	public MaintenanceHistoryEO getMaintenanceById(@PathVariable String id){
		return serviceRef.findMaintenanceById(id);
	}
	@GetMapping("/maintenance/equipment/active/{id}")
	public MaintenanceHistoryEO getActiveMaintenanceByEquipId(@PathVariable String id){
		return serviceRef.findActiveMaintenanceByEquipmentId(id);
	}
	@GetMapping("/maintenance/equipment/{id}")
	public List<MaintenanceHistoryEO> getMaintenanceByEquipId(@PathVariable String id){
		System.out.println("Being called right with id" + id);
		return serviceRef.findByEquipmentId(id);
	}
	@GetMapping("/maintenance/provider/{providerId}")
	public List<MaintenanceHistoryEO> getMaintenanceByProviderId(@PathVariable String providerId){
		return serviceRef.findByProviderId(providerId);
	}
	@GetMapping("/maintenance/tech/{techEmail}")
	public List<MaintenanceHistoryEO> getMaintenanceByTechEmail(@PathVariable String techEmail){
		return serviceRef.findByTechEmail(techEmail);
	}
	@PostMapping("/maintenance")
	public MaintenanceHistoryEO addOrUpdateMaintenance(@RequestBody MaintenanceHistoryEO maintenance){
		return serviceRef.addOrUpdateMaintenance(maintenance);
	}
}
