package com.trintel.equipment.maintenance.service;

import java.util.List;

import com.trintel.equipment.maintenance.entities.BillEO;
import com.trintel.equipment.maintenance.entities.CatalogEO;
import com.trintel.equipment.maintenance.entities.EquipmentEO;
import com.trintel.equipment.maintenance.entities.MaintenanceHistoryEO;
import com.trintel.equipment.maintenance.entities.OrderEO;
import com.trintel.equipment.maintenance.entities.OrderItemEO;
import com.trintel.equipment.maintenance.entities.ProviderEO;
import com.trintel.equipment.maintenance.entities.UsageLogEO;
import com.trintel.equipment.maintenance.entities.UserEO;

public interface MaintenanceTeamService {
	//Order
	public List<OrderEO> findAllOrder();
	public OrderEO findOrderById(String orderId);
	public OrderEO addOrUpdateOrder(OrderEO order);
	public List<OrderEO> findOrderByProviderId(String providerId);
	public String getOrdersKPI();
	
	//OrderItem
	public OrderItemEO addOrUpdateOrderItem(OrderItemEO orderItem);
	
	//Bill
	public List<BillEO> findAllBills();
	public BillEO findBillById(String billNumber);
	
	//Equipment
	public List<EquipmentEO> findAllEquipment();
	public List<EquipmentEO> findEquipmentByProviderId(String providerId);
	public EquipmentEO findEquipmentById(String equipmentId);
	public EquipmentEO addOrUpdateEquipment(EquipmentEO equipment);
	public String getEquipmentKPIs();
	public String getEquipmentKPIById(String equipmentId);
	public List<EquipmentEO> findEquipmentByOrderNum(String orderNum);
	public List<EquipmentEO> findMaintenanceEligibleEquipment();
	
	//Maintenance
	public List<MaintenanceHistoryEO> findAllMaintenance();
	public MaintenanceHistoryEO findMaintenanceById(String maintenanceId);
	public List<MaintenanceHistoryEO> findMaintenanceByProviderId(String providerId);
	public List<MaintenanceHistoryEO> findMaintenanceByEquipmentId(String equipmentId);
	public MaintenanceHistoryEO addOrUpdateMaintenance(MaintenanceHistoryEO maintenance);
	
	//Provider
	public List<ProviderEO> findAllProvider();
	public ProviderEO findProviderById(String providerId);
	public ProviderEO addOrUpdateProvider(ProviderEO provider);
	
	//User
	public UserEO addOrUpdateUser(UserEO user);
	public UserEO authenticateUser(String email, String password);
	
	//Catalog
	public List<CatalogEO> findAllCatalogItems();
	
	//UsageLog
	public List<UsageLogEO> findByEquipmentId(String equipmentId);
}
