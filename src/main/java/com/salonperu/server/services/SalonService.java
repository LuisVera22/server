package com.salonperu.server.services;

import com.salonperu.server.models.Salon;
import com.salonperu.server.models.dto.SalonDTO;
import com.salonperu.server.repositories.ISalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SalonService {
    @Autowired
    private ISalonRepository repoSalon;

    public List<Salon> getSalones() {
        return repoSalon.findAll();
    }

    public  Salon getSalonById(int id) {
        return repoSalon.findById(id).orElse(null);
    }

    public Salon saveSalon(Salon salon) {
        return repoSalon.save(salon);
    }

    public Salon updateSalon(Salon salon) {
        return repoSalon.save(salon);
    }

    public void deleteSalon(int id) {
        repoSalon.deleteById(id);
    }
    @Transactional(readOnly = true)
    public List<SalonDTO> obtenerSalones() {
        List<Object[]> resultados = repoSalon.obtenerSalonesCompletos();
        List<SalonDTO> salones = new ArrayList<>();

        for (Object[] fila : resultados) {
            SalonDTO dto = new SalonDTO();

            dto.id = ((Number) fila[0]).intValue();
            dto.usuarioid = ((Number) fila[1]).intValue();
            dto.telefono = (String) fila[2];
            dto.nombre = (String) fila[3];
            dto.descripcion = (String) fila[4];
            dto.capacidad = ((Number) fila[5]).intValue();
            dto.direccion = (String) fila[6];
            dto.region = (String) fila[7];
            dto.precio = (BigDecimal) fila[8];

            // Parsear listas desde Strings separados por coma
            dto.categorias = new ArrayList<>(Arrays.asList(((String) fila[9]).split(",\\s*")));
            dto.tipoeventos = new ArrayList<>(Arrays.asList(((String) fila[10]).split(",\\s*")));
            dto.imagenes = new ArrayList<>(Arrays.asList(((String) fila[11]).split(",\\s*")));

            salones.add(dto);
        }

        return salones;
    }

    @Transactional(readOnly = true)
    public SalonDTO obtenerSalonPorId(Integer salonId) {
        // Llamamos al repositorio pasando el ID del salón
        List<Object[]> resultados = repoSalon.obtenerSalonCompleto(salonId);

        // Si no hay resultados, devolvemos null o puedes lanzar una excepción personalizada
        if (resultados.isEmpty()) {
            return null;
        }

        Object[] fila = resultados.get(0);
        SalonDTO dto = new SalonDTO();

        // Mapear los resultados a nuestro DTO
        dto.id = ((Number) fila[0]).intValue();
        dto.usuarioid = ((Number) fila[1]).intValue();
        dto.telefono = (String) fila[2];
        dto.nombre = (String) fila[3];
        dto.descripcion = (String) fila[4];
        dto.capacidad = ((Number) fila[5]).intValue();
        dto.direccion = (String) fila[6];
        dto.region = (String) fila[7];
        dto.precio = (BigDecimal) fila[8];

        // Parsear listas desde Strings separados por coma
        dto.categorias = new ArrayList<>(Arrays.asList(((String) fila[9]).split(",\\s*")));
        dto.tipoeventos = new ArrayList<>(Arrays.asList(((String) fila[10]).split(",\\s*")));
        dto.imagenes = new ArrayList<>(Arrays.asList(((String) fila[11]).split(",\\s*")));

        return dto;
    }

}
