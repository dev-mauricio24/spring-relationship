package com.datacenter.eud.course.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datacenter.eud.course.dto.DepartmentDTO;
import com.datacenter.eud.course.services.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentApi {

	private final DepartmentService service;

	@GetMapping
	public ResponseEntity<?> finAll() {
		List<DepartmentDTO> result = this.service.findAll();

		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
	}

}
