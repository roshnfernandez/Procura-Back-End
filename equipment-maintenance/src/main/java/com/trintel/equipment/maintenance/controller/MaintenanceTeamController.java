package com.trintel.equipment.maintenance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trintel.equipment.maintenance.entities.BillEO;
import com.trintel.equipment.maintenance.entities.CatalogEO;
import com.trintel.equipment.maintenance.entities.EquipmentEO;
import com.trintel.equipment.maintenance.entities.MaintenanceHistoryEO;
import com.trintel.equipment.maintenance.entities.OrderEO;
import com.trintel.equipment.maintenance.entities.ProviderEO;
import com.trintel.equipment.maintenance.entities.UsageLogEO;
import com.trintel.equipment.maintenance.entities.UserEO;
import com.trintel.equipment.maintenance.service.MaintenanceTeamService;

@RestController()
@RequestMapping("/trintel")
@CrossOrigin(origins="http://localhost:3000", allowedHeaders="*")
public class MaintenanceTeamController {
	
	@Autowired
	private MaintenanceTeamService serviceRef;
	
	//User
	@PostMapping("/authenticate")
	public UserEO authenticateUser(@RequestBody Map<String, Object> data){
		System.out.println(data);
		return serviceRef.authenticateUser((String)data.get("email"),(String)data.get("password"));
	}
	
	//Orders
	@GetMapping("/orders")
	public List<OrderEO> getAllOrders(){
		return serviceRef.findAllOrder();
	}
	@GetMapping("/orders/{orderId}")
	public OrderEO getOrderById(@PathVariable String orderId){
		return serviceRef.findOrderById(orderId);
	}
	@GetMapping("/orders/kpi")
	public String getOrdersKPI(){
		return serviceRef.getOrdersKPI();
	}
	@GetMapping("/order/provider/{providerId}")
	public List<OrderEO> getOrderByProviderId(@PathVariable String providerId){
		return serviceRef.findOrderByProviderId(providerId);
	}
	@PostMapping("/orders")
	public OrderEO addOrUpdateOrders(@RequestBody OrderEO order){
		OrderEO res = serviceRef.addOrUpdateOrder(order);
		System.out.println(res);
		return res;
	}
	
	//Bills
	@GetMapping("/bills")
	public List<BillEO> getAllBills(){
		return serviceRef.findAllBills();
	}
	@GetMapping("/bills/{billNum}")
	public BillEO getBillById(@PathVariable String billNum){
		return serviceRef.findBillById(billNum);
	}
	
	//Equipment
	@GetMapping("/equipment")
	public List<EquipmentEO> getAllEquipment(){
		return serviceRef.findAllEquipment();
	}
	@GetMapping("/maintenance/eligible/equipment")
	public List<EquipmentEO> getMaintenanceEligibleEquipment(){
		return serviceRef.findMaintenanceEligibleEquipment();
	}
	@GetMapping("/equipment/{equipmentId}")
	public EquipmentEO getEquipmentById(@PathVariable String equipmentId){
		return serviceRef.findEquipmentById(equipmentId);
	}
	@GetMapping("/equipment/kpi")
	public String getEquipmentKPI(){
		return serviceRef.getEquipmentKPIs();
	}
	@GetMapping("/equipment/kpi/{equipmentId}")
	public String getEquipmentKPIById(@PathVariable String equipmentId){
		return serviceRef.getEquipmentKPIById(equipmentId);
	}
	@PostMapping("/equipment")
	public EquipmentEO addOrUpdateEquipment(@RequestBody EquipmentEO equipment){
		return serviceRef.addOrUpdateEquipment(equipment);
	}
	@GetMapping("/equipment/provider/{providerId}")
	public List<EquipmentEO> getEquipmentByProviderId(@PathVariable String providerId){
		return serviceRef.findEquipmentByProviderId(providerId);
	}
	@GetMapping("/equipment/order/{orderNum}")
	public List<EquipmentEO> getEquipmentByOrderNum(@PathVariable String orderNum){
		return serviceRef.findEquipmentByOrderNum(orderNum);
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
	@PostMapping("/maintenance")
	public MaintenanceHistoryEO addOrUpdateMaintenance(@RequestBody MaintenanceHistoryEO maintenance){
		return serviceRef.addOrUpdateMaintenance(maintenance);
	}
	@GetMapping("/provider/maintenance/{providerId}")
	public List<MaintenanceHistoryEO> getMaintenanceByProviderId(@PathVariable String providerId){
		return serviceRef.findMaintenanceByProviderId(providerId);
	}
	@GetMapping("/equipment/maintenance/{equipmentId}")
	public List<MaintenanceHistoryEO> getMaintenanceByEquipmentId(@PathVariable String equipmentId){
		return serviceRef.findMaintenanceByEquipmentId(equipmentId);
	}
	//Provider
	@GetMapping("/provider")
	public List<ProviderEO> getAllProviders(){
		return serviceRef.findAllProvider();
	}
	@GetMapping("/provider/{providerId}")
	public ProviderEO getProviderById(@PathVariable String providerId){
		return serviceRef.findProviderById(providerId);
	}
	@PostMapping("/provider")
	public ProviderEO addOrUpdateProvider(@RequestBody ProviderEO provider){
		return serviceRef.addOrUpdateProvider(provider);
	}
	//Catalog
	@GetMapping("/catalog")
	public List<CatalogEO> getAllCatalogItems(){
		return serviceRef.findAllCatalogItems();
	}
	//Usage Log
	@GetMapping("/equipment/log/{equipmentId}")
	public List<UsageLogEO> getByEquipmentId(@PathVariable String equipmentId){
		return serviceRef.findByEquipmentId(equipmentId);
	}
}
