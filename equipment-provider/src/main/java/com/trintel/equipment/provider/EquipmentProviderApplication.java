package com.trintel.equipment.provider;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.trintel.equipment.provider.customrepository.impl.CustomRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories (repositoryBaseClass = CustomRepositoryImpl.class)
public class EquipmentProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentProviderApplication.class, args);
	}

}
