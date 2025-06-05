package com.salonperu.server.controller;

import com.salonperu.server.model.Distrito;
import com.salonperu.server.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/distritos")
public class DistritoController {
    @Autowired
    private DistritoService distritoService;

    @GetMapping
    public ResponseEntity<List<Distrito>> listarDistritos(){
        List<Distrito> distritos = distritoService.getAllDistritos();

        if(distritos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(distritos, HttpStatus.OK);
    }
}
