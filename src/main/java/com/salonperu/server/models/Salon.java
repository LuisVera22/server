package com.salonperu.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "salones")
@Data
@ToString
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private int capacidad;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Column(name = "precio_base", precision = 10, scale = 2)
    private BigDecimal precioBase;

    @ManyToMany
    @JoinTable(
            name = "salon_caracteristicas",
            joinColumns = @JoinColumn(name = "salon_id"),
            inverseJoinColumns = @JoinColumn(name = "caracteristica_id")
    )
    private Set<CaracteristicaSalon> caracteristicas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "salon_eventos",
            joinColumns = @JoinColumn(name = "salon_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_evento_id")
    )
    private Set<TipoEvento> tiposEvento = new HashSet<>();

    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenSalon> imagenes = new ArrayList<>();
}
