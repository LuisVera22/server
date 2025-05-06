package com.salonperu.server.repositories;

import com.salonperu.server.models.CaracteristicaSalon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICaracteristicasSalonRepository extends JpaRepository<CaracteristicaSalon, Integer> {
}
