package com.salonperu.server.service;

import com.salonperu.server.model.Caracteristica;
import com.salonperu.server.repository.ICaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicaService {
    @Autowired
    private ICaracteristicaRepository repoCaracteristica;

    public List<Caracteristica> listaCaracteristicas() {
        return repoCaracteristica.findAll();
    }
}
