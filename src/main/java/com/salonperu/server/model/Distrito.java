package com.salonperu.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "distritos")
@Data
public class Distrito {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String ubigeo;
    private String distrito;
    private byte estado;
    private int idprovincia;
}
