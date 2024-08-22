package com.trintel.equipment.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.trintel.equipment.maintenance.customrepository.impl.CustomRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories (repositoryBaseClass = CustomRepositoryImpl.class)
public class EquipmentMaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentMaintenanceApplication.class, args);
	}

}
