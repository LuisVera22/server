package com.salonperu.server.repositories;

import com.salonperu.server.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.password = :password")
    Optional<Usuario> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
