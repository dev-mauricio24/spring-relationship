package com.datacenter.eud.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.datacenter.eud.course.dto.LocationDTO;
import com.datacenter.eud.course.dto.RegionDTO;
import com.datacenter.eud.course.persistence.entities.LocationEntity;
import com.datacenter.eud.course.persistence.entities.RegionEntity;
import com.datacenter.eud.course.persistence.repositories.RegionRepository;
import com.github.dozermapper.core.DozerBeanMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
	
	private final RegionRepository repository;
	private final DozerBeanMapper dbm;

	@Override
	public RegionDTO findById(Long id) {
		Optional<RegionEntity> opt = this.repository.findById(id);
		
		if(opt.isPresent()) {
			return this.dbm.map(opt.get(), RegionDTO.class);
		}
		return null;
	}

	@Override
	public RegionDTO findRegionLocations(Long id) {
		RegionEntity region = this.repository.findById(id).orElse(null);
		
		if(region != null) {
			 List<LocationDTO> locations = this.repository.findRegionLocations(id).stream()
					 .map(location -> LocationDTO.builder()
					 .id(location.getId())
					 .streetAddress(location.getStreetAddress())
	                    .postalCode(location.getPostalCode())
	                    .city(location.getCity())
	                    .stateProvince(location.getStateProvince())
	                    .CountryId(location.getCountry().getId())
	                    .build()).toList();

			 
			 return RegionDTO.builder()
			            .id(region.getId())
			            .name(region.getName())
			            .locations(locations)
			            .build();
		}
		return null;
	}

}
