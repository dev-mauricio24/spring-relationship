package com.datacenter.eud.course.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datacenter.eud.course.dto.EmployeeDTO;
import com.datacenter.eud.course.dto.EmployeeJobDTO;


@Service
public interface EmployeeService {
	
	public List<EmployeeDTO> findAll();
	public List<EmployeeDTO> findAll(int limit);
	public EmployeeDTO findById(Long id);
	public EmployeeJobDTO findEmployeeJobById(Long id);
	
}
