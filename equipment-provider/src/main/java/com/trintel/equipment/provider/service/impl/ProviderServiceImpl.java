package com.trintel.equipment.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trintel.equipment.provider.entities.BillEO;
import com.trintel.equipment.provider.entities.BillItemEO;
import com.trintel.equipment.provider.entities.EquipmentEO;
import com.trintel.equipment.provider.entities.MaintenanceHistoryEO;
import com.trintel.equipment.provider.entities.OrderEO;
import com.trintel.equipment.provider.entities.OrderItemEO;
import com.trintel.equipment.provider.repository.BillItemRepository;
import com.trintel.equipment.provider.repository.BillRepository;
import com.trintel.equipment.provider.repository.EquipmentRepository;
import com.trintel.equipment.provider.repository.MaintenanceRepository;
import com.trintel.equipment.provider.repository.OrderItemRepository;
import com.trintel.equipment.provider.repository.OrderRepository;
import com.trintel.equipment.provider.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {
	
	@Autowired
	OrderRepository orderRep;
	@Autowired
	OrderItemRepository orderItemRep;
	@Autowired
	BillRepository billRep;
	@Autowired
	BillItemRepository billItemRep;
	@Autowired
	MaintenanceRepository maintRep;
	@Autowired
	EquipmentRepository equipRep;
	
	@Override
	public List<OrderEO> findAllOrder() {
		// TODO Auto-generated method stub
		return orderRep.findAll();
	}

	@Override
	public OrderEO findOrderById(String orderId) {
		// TODO Auto-generated method stub
		return orderRep.findById(orderId).get();
	}

	@Override
	public OrderEO addOrUpdateOrder(OrderEO order) {
		// TODO Auto-generated method stub
		OrderEO res;
		if(order.getOrderNum().equals("")){
			res = orderRep.saveWithPkReturn(order,"orderNum");
			for(OrderItemEO ordIt: res.getOrderItems())
			  ordIt = addOrUpdateOrderItem(ordIt);
			return res;
		}
		for(OrderItemEO ordIt: order.getOrderItems())
			  ordIt = addOrUpdateOrderItem(ordIt);
		return orderRep.save(order);
	}

	@Override
	public OrderItemEO addOrUpdateOrderItem(OrderItemEO orderItem) {
		// TODO Auto-generated method stub
		if(orderItem.getItemId().equals("")){
			OrderItemEO res = orderItemRep.saveWithPkReturn(orderItem,"itemId");
			return res;
		}
		return orderItemRep.save(orderItem);
	}

	@Override
	public List<BillEO> findAllBills() {
		// TODO Auto-generated method stub
		return billRep.findAll();
	}

	@Override
	public BillEO findBillById(String billNumber) {
		// TODO Auto-generated method stub
		return billRep.findById(billNumber).get();
	}

	@Override
	public BillEO addOrUpdateBill(BillEO bill) {
		// TODO Auto-generated method stub
		BillEO res;
		if(bill.getBillNumber().equals("")){
			res = billRep.saveWithPkReturn(bill,"billNumber");
			for(BillItemEO billIt: res.getBillItems())
			{
				billIt.setBills(res.getBillNumber());
			  billIt = addOrUpdateBillItem(billIt);
			}
			return res;
		}
		for(BillItemEO billIt: bill.getBillItems())
			  billIt = addOrUpdateBillItem(billIt);
		return billRep.save(bill);
	}

	@Override
	public BillItemEO addOrUpdateBillItem(BillItemEO billItem) {
		// TODO Auto-generated method stub
		if(billItem.getItemId().equals(""))
			return billItemRep.saveWithPkReturn(billItem, "itemId");
		return billItemRep.save(billItem);
	}

	@Override
	public List<MaintenanceHistoryEO> findAllMaintenance() {
		// TODO Auto-generated method stub
		return maintRep.findAll();
	}

	@Override
	public MaintenanceHistoryEO findMaintenanceById(String maintenanceId) {
		// TODO Auto-generated method stub
		return maintRep.findById(maintenanceId).get();
	}

	@Override
	public MaintenanceHistoryEO addOrUpdateMaintenance(MaintenanceHistoryEO maintenance) {
		// TODO Auto-generated method stub
		if(maintenance.getId()=="")
			return maintRep.saveWithPkReturn(maintenance, "id");
		return maintRep.save(maintenance);
	}

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
	public EquipmentEO addOrUpdateEquipment(EquipmentEO equipment) {
		// TODO Auto-generated method stub
		if(equipment.getEquipmentId()=="")
			return equipRep.saveWithPkReturn(equipment, "equipmentId");
		return equipRep.save(equipment);
	}

	@Override
	public MaintenanceHistoryEO findActiveMaintenanceByEquipmentId(String equipmentId) {
		// TODO Auto-generated method stub
		return maintRep.findActiveMaintenanceByEquipmentId(equipmentId);
	}

	@Override
	public List<MaintenanceHistoryEO> findByProviderId(String providerId) {
		// TODO Auto-generated method stub
		return maintRep.findByProviderId(providerId);
	}

	@Override
	public List<MaintenanceHistoryEO> findByTechEmail(String techEmail) {
		// TODO Auto-generated method stub
		return maintRep.findByTechEmail(techEmail);
	}

	@Override
	public List<MaintenanceHistoryEO> findByEquipmentId(String equipmentId) {
		// TODO Auto-generated method stub
		return maintRep.findByEquipmentId(equipmentId);
	}

	@Override
	public List<OrderEO> findByUserId(String userId) {
		// TODO Auto-generated method stub
		return orderRep.getOrdersByUserId(userId);
	}

	@Override
	public String getOrderKPI(String userId) {
		// TODO Auto-generated method stub
		return orderRep.getOrderKPISByProviderId(userId);
	}

}
