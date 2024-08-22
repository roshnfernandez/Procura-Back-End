package com.trintel.equipment.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.trintel.equipment.admin.customrepository.impl.CustomRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass=CustomRepositoryImpl.class)
public class EquipmentAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentAdminApplication.class, args);
	}

}
