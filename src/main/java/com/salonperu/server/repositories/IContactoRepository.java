package com.salonperu.server.repositories;

import com.salonperu.server.models.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactoRepository extends JpaRepository<Contacto, Integer> {
}
