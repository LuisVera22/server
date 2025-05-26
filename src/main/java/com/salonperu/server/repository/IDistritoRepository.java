package com.salonperu.server.repository;

import com.salonperu.server.model.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistritoRepository extends JpaRepository<Distrito, Integer> {
}
