package com.salonperu.server.service;

import com.salonperu.server.model.Departamento;
import com.salonperu.server.repository.IDepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {
    @Autowired
    private IDepartamentoRepository repoDepartamento;

    public List<Departamento> getAllDepartamentos() {
        return repoDepartamento.findAll();
    }
}
