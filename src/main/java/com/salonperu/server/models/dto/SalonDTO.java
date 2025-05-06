package com.salonperu.server.models.dto;

import java.math.BigDecimal;
import java.util.List;

public class SalonDTO {
    public int id;
    public int usuarioid;
    public String telefono;
    public String nombre;
    public String descripcion;
    public int capacidad;
    public String direccion;
    public String region;
    public BigDecimal precio;
    public List<String> categorias;
    public List<String> tipoeventos;
    public List<String> imagenes;
}
