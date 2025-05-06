package com.salonperu.server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "imagenes_salon")
@Data
@ToString
public class ImagenSalon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = false)
    private Salon salon;

    @Column(name = "url_imagen", nullable = false, length = 255)
    private String urlImagen;

    @Column(name = "es_principal")
    private Boolean esPrincipal = false;
}
