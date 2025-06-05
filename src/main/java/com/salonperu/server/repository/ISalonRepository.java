package com.salonperu.server.repository;

import com.salonperu.server.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalonRepository extends JpaRepository<Salon, Integer> {
}
