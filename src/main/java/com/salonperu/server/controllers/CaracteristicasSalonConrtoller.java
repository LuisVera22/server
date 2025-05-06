package com.salonperu.server.controllers;

import com.salonperu.server.models.CaracteristicaSalon;
import com.salonperu.server.services.CaracteristicasSalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/caracteristicas-salon")
@CrossOrigin(origins = "http://localhost:4200")
public class CaracteristicasSalonConrtoller {

    @Autowired
    private CaracteristicasSalonService caracteristicasSalonService;

    @GetMapping
    public ResponseEntity<List<CaracteristicaSalon>> listarCaracteristicasSalon() {
        List<CaracteristicaSalon> caracteristicasSalon = caracteristicasSalonService.getCaracteristicasSalon();

        if (caracteristicasSalon.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(caracteristicasSalon);
    }
}
