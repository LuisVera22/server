package com.salonperu.server.services;

import com.salonperu.server.models.Contacto;
import com.salonperu.server.repositories.IContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService {
    @Autowired
    private IContactoRepository repoContacto;

    public Contacto getContactoById(int id) {
        return repoContacto.findById(id).orElse(null);
    }
}
