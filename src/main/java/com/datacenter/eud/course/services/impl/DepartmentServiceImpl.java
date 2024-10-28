package com.datacenter.eud.course.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datacenter.eud.course.dto.DepartmentDTO;
import com.datacenter.eud.course.persistence.entities.DepartmentEntity;
import com.datacenter.eud.course.persistence.repositories.DepartmentRepository;
import com.datacenter.eud.course.services.DepartmentService;
import com.github.dozermapper.core.DozerBeanMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository repository;
	private final DozerBeanMapper dbm;

	@Override
	public List<DepartmentDTO> findAll() {
		List<DepartmentEntity> result = (List<DepartmentEntity>) this.repository.findAll();
		return result.stream().map(em -> this.dbm.map(em, DepartmentDTO.class)).toList();
	}

}
