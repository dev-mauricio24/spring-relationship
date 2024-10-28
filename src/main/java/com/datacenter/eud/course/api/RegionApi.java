package com.datacenter.eud.course.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datacenter.eud.course.dto.RegionDTO;
import com.datacenter.eud.course.services.RegionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/regions")
@RequiredArgsConstructor
public class RegionApi {
	
	private final RegionService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findRegionLocations(@PathVariable Long id) {
		RegionDTO dto = this.service.findRegionLocations(id);
		return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
}
