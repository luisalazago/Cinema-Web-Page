package com.cinedigital.cine_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Teatro")
public class Teatro {
    @Id
    @Column(length = 100)
    private String id;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String direccion;

    // Relación: Uno o muchos teatros pertenecen a una ciudad.
    @ManyToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
    private Ciudad ciudad;

    // Constructor
    public Teatro() {
    }

    // Métodos Set
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    // Métodos Get
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
