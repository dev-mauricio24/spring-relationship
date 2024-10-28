package com.datacenter.eud.course.services;

import org.springframework.stereotype.Service;

import com.datacenter.eud.course.dto.RegionDTO;

@Service
public interface RegionService {
	public RegionDTO findById(Long id);
	public RegionDTO findRegionLocations(Long id);
}
