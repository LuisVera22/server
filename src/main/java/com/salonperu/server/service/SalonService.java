package com.salonperu.server.service;

import com.salonperu.server.model.Salon;
import com.salonperu.server.repository.ISalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {
    @Autowired
    private ISalonRepository repoSalon;

    public List<Salon> listSalones() {
        return repoSalon.findAll();
    }
}
