package com.trintel.equipment.maintenance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.trintel.equipment.maintenance.entities.BillEO;
import com.trintel.equipment.maintenance.entities.CatalogEO;
import com.trintel.equipment.maintenance.entities.EquipmentEO;
import com.trintel.equipment.maintenance.entities.MaintenanceHistoryEO;
import com.trintel.equipment.maintenance.entities.OrderEO;
import com.trintel.equipment.maintenance.entities.OrderItemEO;
import com.trintel.equipment.maintenance.entities.ProviderEO;
import com.trintel.equipment.maintenance.entities.UsageLogEO;
import com.trintel.equipment.maintenance.entities.UserEO;
import com.trintel.equipment.maintenance.repository.BillRepository;
import com.trintel.equipment.maintenance.repository.CatalogRepository;
import com.trintel.equipment.maintenance.repository.EquipmentRepository;
import com.trintel.equipment.maintenance.repository.MaintenanceRepository;
import com.trintel.equipment.maintenance.repository.OrderItemRepository;
import com.trintel.equipment.maintenance.repository.OrderRepository;
import com.trintel.equipment.maintenance.repository.ProviderRepository;
import com.trintel.equipment.maintenance.repository.UsageLogRepository;
import com.trintel.equipment.maintenance.repository.UserRepository;
import com.trintel.equipment.maintenance.service.MaintenanceTeamService;


@Service
@Component
public class MaintenanceTeamServiceImpl implements MaintenanceTeamService {
	@Autowired
	OrderRepository orderRep;
	@Autowired
	OrderItemRepository orderItemRep;
	@Autowired
	BillRepository billRep;
	@Autowired
	EquipmentRepository equipRep;
	@Autowired
	MaintenanceRepository maintRep;
	@Autowired
	ProviderRepository provRep;
	@Autowired
	UserRepository userRep;
	@Autowired
	CatalogRepository catalogRep;
	@Autowired
	UsageLogRepository useLogRep;
	
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
			for(OrderItemEO ordIt: res.getOrderItems()){
				ordIt.setorder(res.getOrderNum());
			  ordIt = addOrUpdateOrderItem(ordIt);
			}
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
		if(equipment.getEquipmentId().equals("")){
			EquipmentEO res = equipRep.saveWithPkReturn(equipment,"equipmentId");
			return res;
		}
		return equipRep.save(equipment);
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
		if(maintenance.getId().equals("")){
			MaintenanceHistoryEO res = maintRep.saveWithPkReturn(maintenance,"id");
			return res;
		}
		return maintRep.save(maintenance);
	}

	@Override
	public List<ProviderEO> findAllProvider() {
		// TODO Auto-generated method stub
		return provRep.findAll();
	}

	@Override
	public ProviderEO findProviderById(String providerId) {
		// TODO Auto-generated method stub
		return provRep.findById(providerId).get();
	}

	@Override
	public ProviderEO addOrUpdateProvider(ProviderEO provider) {
		// TODO Auto-generated method stub
		if(provider.getProviderId().equals("")){
			UserEO usr = addOrUpdateUser(provider.getUsers());
			provider.setUsers(usr);
			ProviderEO res = provRep.saveWithPkReturn(provider,"providerId");
			return res;
		}
		addOrUpdateUser(provider.getUsers());
		return provRep.save(provider);
	}

	@Override
	public UserEO addOrUpdateUser(UserEO user) {
		// TODO Auto-generated method stub
		if(user.getUserId().equals(""))
			return userRep.saveWithPkReturn(user, "userId");
		return userRep.save(user);
	}
	
	@Override
	public List<OrderEO> findOrderByProviderId(String providerId) {
		// TODO Auto-generated method stub
		return orderRep.findByProviderId(providerId);
	}

	@Override
	public List<MaintenanceHistoryEO> findMaintenanceByProviderId(String providerId) {
		// TODO Auto-generated method stub
		return maintRep.findByProviderId(providerId);
	}

	@Override
	public List<CatalogEO> findAllCatalogItems() {
		// TODO Auto-generated method stub
		return catalogRep.findAll();
	}

	@Override
	public List<MaintenanceHistoryEO> findMaintenanceByEquipmentId(String equipmentId) {
		// TODO Auto-generated method stub
		return maintRep.findByEquipmentId(equipmentId);
	}

	@Override
	public List<EquipmentEO> findEquipmentByProviderId(String providerId) {
		// TODO Auto-generated method stub
		return equipRep.findByProviderId(providerId);
	}

	@Override
	public String getEquipmentKPIs() {
		// TODO Auto-generated method stub
		return equipRep.getEquipmentKPI();
	}

	@Override
	public List<EquipmentEO> findEquipmentByOrderNum(String orderNum) {
		// TODO Auto-generated method stub
		return equipRep.findByOrderNum(orderNum);
	}

	@Override
	public String getOrdersKPI() {
		// TODO Auto-generated method stub
		return orderRep.getOrdersKPI();
	}

	@Override
	public UserEO authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		return userRep.authenticateUser(email, password);
	}

	@Override
	public List<EquipmentEO> findMaintenanceEligibleEquipment() {
		// TODO Auto-generated method stub
		return equipRep.findMaintenanceEligibleEquipment();
	}

	@Override
	public List<UsageLogEO> findByEquipmentId(String equipmentId) {
		// TODO Auto-generated method stub
		return useLogRep.findByEquipmentId(equipmentId);
	}

	@Override
	public String getEquipmentKPIById(String equipmentId) {
		// TODO Auto-generated method stub
		return equipRep.getEquipmentKPIById(equipmentId);
	}
}
