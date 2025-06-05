package com.salonperu.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "imagenes_salon")
@Data
public class ImagenesSalon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "salon_id")
    private int salon;

    @Column(name = "url_imagen")
    private String url;

    @Column(name = "es_principal")
    private Boolean principal;
}
