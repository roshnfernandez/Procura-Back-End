package com.trintel.equipment.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trintel.equipment.admin.entities.CatalogEO;
import com.trintel.equipment.admin.entities.CategoryEO;
import com.trintel.equipment.admin.entities.RoleEO;
import com.trintel.equipment.admin.entities.UserEO;
import com.trintel.equipment.admin.service.AdminService;

@RestController
@RequestMapping("/trintel")
@CrossOrigin(origins="http://localhost:3000", allowedHeaders="*")
public class AdminController {
	@Autowired
	AdminService serviceRef;
	//User
	@GetMapping("/users")
	public List<UserEO> findAllUsers(){
		return serviceRef.findAllUser();
	}
	@GetMapping("/users/{userId}")
	public UserEO findUserById(@PathVariable String userId){
		return serviceRef.findUserById(userId);
	}
	@PostMapping("/users")
	public UserEO addOrUpdateUser(@RequestBody UserEO user){
		return serviceRef.addOrUpdateUser(user);
	}
	//Role
	@GetMapping("/roles")
	public List<RoleEO> findAllRoles(){
		return serviceRef.findAllRoles();
	}
	@GetMapping("/roles/{roleId}")
	public RoleEO findRoleById(@PathVariable String roleId){
		return serviceRef.findRoleById(roleId);
	}
	@PostMapping("/roles")
	public RoleEO addOrUpdateRole(@RequestBody RoleEO role){
		return serviceRef.addOrUpdateRole(role);
	}
	//Category
	@GetMapping("/categories")
	public List<CategoryEO> findAllCategories(){
		return serviceRef.findAllCategories();
	}
	@GetMapping("/categories/{categoryId}")
	public CategoryEO findCategoryById(@PathVariable String categoryId){
		return serviceRef.findCategoryById(categoryId);
	}
	@PostMapping("/categories")
	public CategoryEO addOrUpdateCategory(@RequestBody CategoryEO category){
		return serviceRef.addOrUpdateCategory(category);
	}
	//Catalog
	@GetMapping("/catalog")
	public List<CatalogEO> findAllCatalogItems(){
		return serviceRef.findAllCatalogItems();
	}
	@GetMapping("/catalog/{catalogId}")
	public CatalogEO findCatalogItemById(@PathVariable String categoryId){
		return serviceRef.findCatalogItemById(categoryId);
	}
	@PostMapping("/catalog")
	public CatalogEO addOrUpdateCatalogItem(@RequestBody CatalogEO catalogItem){
		return serviceRef.addOrUpdateCatalogItem(catalogItem);
	}
}
