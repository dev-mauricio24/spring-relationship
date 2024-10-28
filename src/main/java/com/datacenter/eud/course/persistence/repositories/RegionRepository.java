package com.datacenter.eud.course.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.datacenter.eud.course.persistence.entities.LocationEntity;
import com.datacenter.eud.course.persistence.entities.RegionEntity;

@Repository
public interface RegionRepository extends CrudRepository<RegionEntity, Long> {

//	  @Query("SELECT DISTINCT r FROM RegionEntity r " +
//	           "JOIN FETCH r.countries c " +
//	           "JOIN FETCH c.locations " +
//	           "WHERE r.id = :regionId")
	@Query("SELECT l FROM LocationEntity l " + "JOIN l.country c " + "JOIN c.region r " + "WHERE r.id = :regionId")
	List<LocationEntity> findRegionLocations(@Param("regionId") Long regionId);
}
