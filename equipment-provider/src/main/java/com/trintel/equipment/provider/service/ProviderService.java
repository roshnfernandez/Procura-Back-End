package com.trintel.equipment.provider.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.trintel.equipment.provider.entities.MaintenanceHistoryEO;
import com.trintel.equipment.provider.entities.EquipmentEO;
import com.trintel.equipment.provider.entities.BillEO;
import com.trintel.equipment.provider.entities.BillItemEO;
import com.trintel.equipment.provider.entities.OrderEO;
import com.trintel.equipment.provider.entities.OrderItemEO;

public interface ProviderService {
	// Order
	public List<OrderEO> findAllOrder();
	public List<OrderEO> findByUserId(String userId);
	public OrderEO findOrderById(String orderId);
	public OrderEO addOrUpdateOrder(OrderEO order);
	public String getOrderKPI(String userId);
	// OrderItem
	public OrderItemEO addOrUpdateOrderItem(OrderItemEO orderItem);
	
	//Bill
	public List<BillEO> findAllBills();
	public BillEO findBillById(String billNumber);
	public BillEO addOrUpdateBill(BillEO bill);
	
	//Bill Item
	public BillItemEO addOrUpdateBillItem(BillItemEO bilItem);
	
	//Maintenance
	public List<MaintenanceHistoryEO> findAllMaintenance();
	public MaintenanceHistoryEO findMaintenanceById(String maintenanceId);
	public MaintenanceHistoryEO addOrUpdateMaintenance(MaintenanceHistoryEO maintenance);
	public MaintenanceHistoryEO findActiveMaintenanceByEquipmentId(String equipmentId);
	public List<MaintenanceHistoryEO> findByProviderId(String providerId);
	public List<MaintenanceHistoryEO> findByEquipmentId(String equipmentId);
	public List<MaintenanceHistoryEO> findByTechEmail(String techEmail);
	
	//Equipment
	public List<EquipmentEO> findAllEquipment();
	public EquipmentEO findEquipmentById(String equipmentId);
	public EquipmentEO addOrUpdateEquipment(EquipmentEO equipment);
}
