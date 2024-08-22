package com.trintel.equipment.admin.service;

import java.util.List;

import com.trintel.equipment.admin.entities.CatalogEO;
import com.trintel.equipment.admin.entities.CategoryEO;
import com.trintel.equipment.admin.entities.OrderEO;
import com.trintel.equipment.admin.entities.RoleEO;
import com.trintel.equipment.admin.entities.UserEO;

public interface AdminService {

	//User
	public List<UserEO> findAllUser();
	public UserEO findUserById(String userId);
	public UserEO addOrUpdateUser(UserEO user);
	
	//Role
	public List<RoleEO> findAllRoles();
	public RoleEO findRoleById(String roleName);
	public RoleEO addOrUpdateRole(RoleEO role);
	
	//Categories
	public List<CategoryEO> findAllCategories();
	public CategoryEO findCategoryById(String id);
	public CategoryEO addOrUpdateCategory(CategoryEO category);
	
	//Catalog
	public List<CatalogEO> findAllCatalogItems();
	public CatalogEO findCatalogItemById(String id);
	public CatalogEO addOrUpdateCatalogItem(CatalogEO catalogItem);
	
}
