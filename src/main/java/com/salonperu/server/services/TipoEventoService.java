package com.salonperu.server.services;

import com.salonperu.server.models.TipoEvento;
import com.salonperu.server.repositories.ITipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEventoService {
    @Autowired
    private ITipoEventoRepository repoTipoEvento;

    public List<TipoEvento> listarTipoEvento() {
        return repoTipoEvento.findAll();
    }
}
