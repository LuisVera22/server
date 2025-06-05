package com.salonperu.server.service;

import com.salonperu.server.model.Evento;
import com.salonperu.server.repository.IEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private IEventoRepository repoEvento;

    public List<Evento> getAllEventos() {
        return repoEvento.findAll();
    }
}
