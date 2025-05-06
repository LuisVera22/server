package com.salonperu.server.controllers;

import com.salonperu.server.models.Region;
import com.salonperu.server.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/regiones")
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> getAllRegions() {
        List<Region> regiones = regionService.getAllRegiones();

        if (regiones.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regiones);
    }
}
