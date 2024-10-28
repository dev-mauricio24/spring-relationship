package com.datacenter.eud.course.persistence.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COUNTRIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity {
	@Id
	@Column(name = "COUNTRY_ID")
	private String id;
	@Column(name = "COUNTRY_NAME")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = RegionEntity.class, optional = false)
	@JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
	private RegionEntity region;
	
	@OneToMany(targetEntity = LocationEntity.class, fetch = FetchType.LAZY, mappedBy = "country")
	@JsonIgnore
	private List<LocationEntity> locations;
} 
