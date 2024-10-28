package com.datacenter.eud.course.persistence.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.datacenter.eud.course.persistence.entities.EmployeeEntity;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

	List<EmployeeEntity> findAll(Pageable pageable);
}
