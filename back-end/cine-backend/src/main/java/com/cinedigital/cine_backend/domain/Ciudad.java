package com.cinedigital.cine_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ciudad") // Nombre de la tabla en SQL
public class Ciudad {
    @Id
    @Column(length = 100)
    private String id;

    @Column(nullable = false, length = 200)
    private String nombre;

    // Constructor
    public Ciudad() {
    }

    // Métodos Set
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos Get
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
