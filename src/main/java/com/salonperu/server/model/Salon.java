package com.salonperu.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "salones")
@Data
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usuario_id")
    private int usuario;

    private String nombre;
    private String descripcion;
    private int capacidad;
    private String direccion;

    @Column(name = "distrito_id")
    private int distrito;

    @Column(name = "precio_base")
    private Double precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", insertable = false, updatable = false)
    private Usuario objUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distrito", insertable = false, updatable = false)
    private Distrito objDistrito;
}
