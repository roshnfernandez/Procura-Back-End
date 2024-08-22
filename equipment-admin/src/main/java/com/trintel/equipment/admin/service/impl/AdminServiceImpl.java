package com.trintel.equipment.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trintel.equipment.admin.entities.CatalogEO;
import com.trintel.equipment.admin.entities.CategoryEO;
import com.trintel.equipment.admin.entities.OrderEO;
import com.trintel.equipment.admin.entities.RoleEO;
import com.trintel.equipment.admin.entities.UserEO;
import com.trintel.equipment.admin.repository.CatalogRepository;
import com.trintel.equipment.admin.repository.CategoryRepository;
import com.trintel.equipment.admin.repository.OrderRepository;
import com.trintel.equipment.admin.repository.RoleRepository;
import com.trintel.equipment.admin.repository.UserRepository;
import com.trintel.equipment.admin.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	@Autowired
	CategoryRepository categRep;
	@Autowired
	CatalogRepository catalogRep;
	@Autowired
	OrderRepository orderRep;
	
	@Override
	public List<UserEO> findAllUser() {
		// TODO Auto-generated method stub
		return userRep.findActiveUsers();
	}

	@Override
	public UserEO findUserById(String userId) {
		// TODO Auto-generated method stub
		return userRep.findById(userId).get();
	}

	@Override
	public UserEO addOrUpdateUser(UserEO user) {
		// TODO Auto-generated method stub
		if(user.getUserId().equals(""))
			return userRep.saveWithPkReturn(user, "userId");
		return userRep.save(user);
	}

	@Override
	public List<RoleEO> findAllRoles() {
		// TODO Auto-generated method stub
		return roleRep.findAll();
	}

	@Override
	public RoleEO findRoleById(String roleName) {
		// TODO Auto-generated method stub
		return roleRep.findById(roleName).get();
	}

	@Override
	public RoleEO addOrUpdateRole(RoleEO role) {
		// TODO Auto-generated method stub
		return roleRep.save(role);
	}

	@Override
	public List<CategoryEO> findAllCategories() {
		// TODO Auto-generated method stub
		return categRep.findAll();
	}

	@Override
	public CategoryEO findCategoryById(String id) {
		// TODO Auto-generated method stub
		return categRep.findById(id).get();
	}

	@Override
	public CategoryEO addOrUpdateCategory(CategoryEO category) {
		// TODO Auto-generated method stub
		if(category.getCategoryId().equals(""))
			return categRep.saveWithPkReturn(category, "categoryId");
		return categRep.save(category);
	}

	@Override
	public List<CatalogEO> findAllCatalogItems() {
		// TODO Auto-generated method stub
		return catalogRep.findActiveProducts();
	}

	@Override
	public CatalogEO findCatalogItemById(String id) {
		// TODO Auto-generated method stub
		return catalogRep.findById(id).get();
	}

	@Override
	public CatalogEO addOrUpdateCatalogItem(CatalogEO catalogItem) {
		// TODO Auto-generated method stub
		if(catalogItem.getCatalogId().equals(""))
			catalogRep.saveWithPkReturn(catalogItem, "catalogId");
		return catalogRep.save(catalogItem);
	}



}
