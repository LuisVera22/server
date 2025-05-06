package com.salonperu.server.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "resenas")
@Data
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = false)
    private Salon salon;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Integer calificacion;

    @Column(columnDefinition = "TEXT")
    private String comentario;
}
