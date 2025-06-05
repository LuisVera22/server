package com.salonperu.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "salon_caracteristicas")
@Data
public class SalonCaracteristicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "salon_id")
    private int salon;

    @Column(name = "caracteristica_id")
    private int caracteristica;
}
