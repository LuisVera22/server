package com.salonperu.server.repositories;

import com.salonperu.server.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegionRepository extends JpaRepository<Region, Integer> {
}
