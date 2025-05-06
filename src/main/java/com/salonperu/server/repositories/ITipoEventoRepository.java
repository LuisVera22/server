package com.salonperu.server.repositories;

import com.salonperu.server.models.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEventoRepository extends JpaRepository<TipoEvento, Integer> {
}
