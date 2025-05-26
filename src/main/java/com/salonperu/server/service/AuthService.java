package com.salonperu.server.service;

import com.salonperu.server.model.Usuario;
import com.salonperu.server.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private IUsuarioRepository repoUsuario;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean existeUsuario(String email) {
        return repoUsuario.existsByEmail(email);
    }

    public Optional<Usuario> login(String email, String password) {
        Optional<Usuario> usuarioOpt = repoUsuario.findByEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            if (passwordEncoder.matches(password, usuario.getPassword())) {
                return Optional.of(usuario);
            }
        }

        return Optional.empty();
    }

    public Usuario registrarUsuario(Usuario usuario) {
        String claveCodificada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(claveCodificada);
        return repoUsuario.save(usuario);
    }
}
