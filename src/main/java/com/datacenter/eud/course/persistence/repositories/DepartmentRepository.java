package com.datacenter.eud.course.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import com.datacenter.eud.course.persistence.entities.DepartmentEntity;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Long> {

}
