package com.trintel.equipment.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.trintel.equipment.user.customrepository.impl.CustomRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass=CustomRepositoryImpl.class)
public class EquipmentUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentUserApplication.class, args);
	}

}
