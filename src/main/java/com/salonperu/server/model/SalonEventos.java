package com.salonperu.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "salon_eventos")
@Data
public class SalonEventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "salon_id")
    private int salon;

    @Column(name = "tipo_evento_id")
    private int tipoEvento;
}
