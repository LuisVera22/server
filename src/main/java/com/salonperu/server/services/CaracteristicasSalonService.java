package com.salonperu.server.services;

import com.salonperu.server.models.CaracteristicaSalon;
import com.salonperu.server.repositories.ICaracteristicasSalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicasSalonService {
    @Autowired
    private ICaracteristicasSalonRepository repoCarateristicasSalon;

    public List<CaracteristicaSalon> getCaracteristicasSalon() {
        return repoCarateristicasSalon.findAll();
    }

    public CaracteristicaSalon getCaracteristicasSalonById(int id) {
        return repoCarateristicasSalon.findById(id).orElse(null);
    }
}
