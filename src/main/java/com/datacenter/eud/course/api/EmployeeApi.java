package com.datacenter.eud.course.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datacenter.eud.course.dto.EmployeeDTO;
import com.datacenter.eud.course.dto.EmployeeJobDTO;
import com.datacenter.eud.course.services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeApi {
	
	private final EmployeeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<EmployeeDTO> result = service.findAll();
		
		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		EmployeeDTO dto = service.findById(id);
		return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/job/{id}")
	public ResponseEntity<?> getEmployeeJobById(@PathVariable Long id) {
		EmployeeJobDTO dto = service.findEmployeeJobById(id);
		return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/limit")
	public ResponseEntity<?> findAll(@RequestParam(required = false, defaultValue = "5") int limit) {
		List<EmployeeDTO> result = service.findAll(limit);
		System.out.println(result.size());
		
		return !result.isEmpty() ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
	}
	
}
