package com.salonperu.server.repositories;

import com.salonperu.server.models.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISalonRepository extends JpaRepository<Salon, Integer> {
    @Query(value = "CALL obtener_salones_completos()", nativeQuery = true)
    List<Object[]> obtenerSalonesCompletos();

    @Query(value = "CALL obtener_salon_completo(:salonId)", nativeQuery = true)
    List<Object[]> obtenerSalonCompleto(@Param("salonId") Integer salonId);
}
