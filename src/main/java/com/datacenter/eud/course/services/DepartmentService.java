package com.datacenter.eud.course.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.datacenter.eud.course.dto.DepartmentDTO;

@Service
public interface DepartmentService {
	List<DepartmentDTO> findAll();
}
