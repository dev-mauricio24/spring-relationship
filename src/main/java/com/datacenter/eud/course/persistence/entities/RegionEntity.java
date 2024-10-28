package com.datacenter.eud.course.persistence.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "REGIONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionEntity {
	   @Id
	    @Column(name = "region_id")
	    private Long id;

	    @Column(name = "region_name")
	    private String name;
	    
	    @OneToMany(targetEntity = CountryEntity.class, fetch = FetchType.EAGER, mappedBy = "region")
	    @JsonIgnore
		private List<CountryEntity> countries;
}
