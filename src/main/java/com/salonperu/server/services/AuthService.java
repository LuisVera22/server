package com.salonperu.server.services;

import com.salonperu.server.models.Usuario;
import com.salonperu.server.repositories.IUsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean existeUsuario(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public Optional<Usuario> login(String email, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

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
        return usuarioRepository.save(usuario);
    }
}
