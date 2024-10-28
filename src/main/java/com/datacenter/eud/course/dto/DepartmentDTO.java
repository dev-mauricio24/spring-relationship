package com.datacenter.eud.course.dto;

import com.datacenter.eud.course.persistence.entities.LocationEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {
	private Long id;
	private String name;
	private Long managerId;
	private LocationEntity location;

}
