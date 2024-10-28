package com.datacenter.eud.course.dto;

import java.util.Date;

import com.datacenter.eud.course.persistence.entities.JobEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class EmployeeJobDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private Double salary;
	private Float commissionPct;
	private Long managerId;
	private Long departmentId;
	private JobEntity job;
}
