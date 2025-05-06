package com.salonperu.server.controllers;

import com.salonperu.server.models.TipoEvento;
import com.salonperu.server.services.TipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-evento")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoEventoController {
    @Autowired
    private TipoEventoService tipoEventoService;

    @GetMapping
    public ResponseEntity<List<TipoEvento>> listarTodos() {
        List<TipoEvento> tiposEvento = tipoEventoService.listarTipoEvento();

        if (tiposEvento.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tiposEvento);
    }
}
