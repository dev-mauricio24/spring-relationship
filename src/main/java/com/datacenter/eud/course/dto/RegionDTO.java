package com.datacenter.eud.course.dto;

import java.util.List;

import com.datacenter.eud.course.persistence.entities.CountryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegionDTO {
    private Long id;
    private String name;
	private List<LocationDTO> locations;
}
