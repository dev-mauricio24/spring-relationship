package com.datacenter.eud.course.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "JOBS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {

	@Id
	@Column(name = "JOB_ID")
	private String jobId;
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	@Column(name = "MIN_SALARY")
	private Double minSalary;
	@Column(name = "MAX_SALARY")
	private Double maxSalary;
}
