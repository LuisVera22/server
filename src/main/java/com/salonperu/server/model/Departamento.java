package com.salonperu.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "departamentos")
@Data
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String departamento;

    private byte estado;
}
