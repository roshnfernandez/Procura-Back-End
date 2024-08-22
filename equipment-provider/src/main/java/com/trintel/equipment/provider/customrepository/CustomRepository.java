package com.trintel.equipment.provider.customrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface CustomRepository<T,ID> extends JpaRepository<T, ID> {
	T saveWithPkReturn(T entity, String fieldName);
}
