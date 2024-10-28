package com.datacenter.eud.course.dto;

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
public class LocationDTO {
	private Long id;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String CountryId;
}
