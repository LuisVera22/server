package com.salonperu.server.repositories;

import com.salonperu.server.models.ImagenSalon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagenSalonRepository extends JpaRepository<ImagenSalon, Integer> {
}
