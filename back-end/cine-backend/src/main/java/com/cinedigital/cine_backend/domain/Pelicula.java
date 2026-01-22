package com.cinedigital.cine_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pelicula") // Nombre de la tabla en la base de datos.
public class Pelicula {
    @Id
    @Column(length = 100)
    private String id;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(name = "duracion_min", nullable = false)
    private Integer duracionMin;

    @Column(name = "url_imagen", length = 500)
    private String urlImagen;

    @Column(nullable = false)
    private Boolean cartelera;

    @Column(nullable = false, length = 100)
    private String genero;

    @Column(nullable = false, length = 50)
    private String clasificacion;

    @Column(length = 2000)
    private String descripcion;

    // Constructor
    public Pelicula() {
    }

    // Métodos Set
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracionMin(Integer duracionMin) {
        this.duracionMin = duracionMin;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public void setCartelera(Boolean cartelera) {
        this.cartelera = cartelera;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos Get
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDuracionMin() {
        return duracionMin;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public Boolean getCartelera() {
        return cartelera;
    }

    public String getGenero() {
        return genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
