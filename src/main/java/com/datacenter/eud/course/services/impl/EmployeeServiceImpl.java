package com.datacenter.eud.course.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.datacenter.eud.course.dto.EmployeeDTO;
import com.datacenter.eud.course.dto.EmployeeJobDTO;
import com.datacenter.eud.course.persistence.entities.EmployeeEntity;
import com.datacenter.eud.course.persistence.repositories.EmployeeRepository;
import com.datacenter.eud.course.services.EmployeeService;
import com.github.dozermapper.core.DozerBeanMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final DozerBeanMapper dbm;
	private final EmployeeRepository repository;

	@Override
	public List<EmployeeDTO> findAll() {
		List<EmployeeEntity> result = (List<EmployeeEntity>) this.repository.findAll();

		return result.stream().map(em -> this.dbm.map(em, EmployeeDTO.class)).toList();
	}

	@Override
	public EmployeeDTO findById(Long id) {
		Optional<EmployeeEntity> optionalEntity = this.repository.findById(id);

		if (optionalEntity.isPresent()) {
			EmployeeEntity entity = optionalEntity.get();
			return dbm.map(entity, EmployeeDTO.class);
		}
		return null;
	}

	@Override
	public EmployeeJobDTO findEmployeeJobById(Long id) {
		Optional<EmployeeEntity> optionalEntity = this.repository.findById(id);

		if (optionalEntity.isPresent()) {
			EmployeeEntity entity = optionalEntity.get();
			return EmployeeJobDTO.builder().id(entity.getId()).firstName(entity.getFirstName())
					.lastName(entity.getLastName()).email(entity.getEmail()).phoneNumber(entity.getPhoneNumber())
					.hireDate(entity.getHireDate()).salary(entity.getSalary()).commissionPct(entity.getCommissionPct())
					.managerId(entity.getManagerId()).departmentId(entity.getDepartment().getId()).job(entity.getJob())
					.build();
		}
		return null;
	}

	@Override
	public List<EmployeeDTO> findAll(int limit) {
		Pageable pageable = PageRequest.of(0, limit);
		
		List<EmployeeEntity> result = this.repository.findAll(pageable);

		return result.stream().map(em -> this.dbm.map(em, EmployeeDTO.class)).toList();
		
	}

}
