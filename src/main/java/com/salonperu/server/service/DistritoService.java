package com.salonperu.server.service;

import com.salonperu.server.model.Distrito;
import com.salonperu.server.repository.IDistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoService {
    @Autowired
    private IDistritoRepository repoDistrito;

    public List<Distrito> getDistritos() {
        return repoDistrito.findAll();
    }
}
